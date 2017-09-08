package com.goutham.hades;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.Socket;


public class MainActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    final Context context = this;
    FloatingActionButton fab = null;
    HadesNetworkThread hnt = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hnt = new HadesNetworkThread(context);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fabClick(view);
            }
        });

        Button one = (Button) findViewById(R.id.button1);
        one.setOnClickListener(this); // calling onClick() method
        Button two = (Button) findViewById(R.id.button2);
        two.setOnClickListener(this);
        Button three = (Button) findViewById(R.id.button3);
        three.setOnClickListener(this);
        Button four = (Button) findViewById(R.id.button4);
        four.setOnClickListener(this); // calling onClick() method
        Button six = (Button) findViewById(R.id.button6);
        six.setOnClickListener(this);
        Button seven = (Button) findViewById(R.id.button7);
        seven.setOnClickListener(this);

    }

    public void fabClick(View view) { //FIXME destroy AsyncTask cleanly
        if (hnt.getStatus() == AsyncTask.Status.RUNNING) {
            hnt.cancel(true);
        }
        hnt.execute();
        fab.setEnabled(false);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button1:
                // do your code
                Log.i("clicks", "You Clicked B1");
                Intent i = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
                break;

            case R.id.button2:
                // do your code
                Log.i("clicks", "You Clicked B2");
                Intent t = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(t);
                break;
            case R.id.button3:
                // do your code
                Log.i("clicks", "You Clicked B3");
                Intent j = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(j);
                break;
            case R.id.button4:
                // do your code
                Log.i("clicks", "You Clicked B4");
                Intent k = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(k);
                break;
            case R.id.button6:
                // do your code
                Log.i("clicks", "You Clicked B5");
                Intent l = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(l);
                break;
            case R.id.button7:
                // do your code
                Log.i("clicks", "You Clicked B6");
                Intent m = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(m);
                break;

            default:
                break;
        }

    }

    // @Override
       /* public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.activity_main, menu);
            return true;
        }*/

       /* @Override
        public void onClick(View v) {
            Log.i("clicks","You Clicked B1");
            Intent i=new Intent(MainActivity.this, MainActivity2.class);
            startActivity(i);
        }*/

    private class HadesNetworkThread extends AsyncTask<String, Void, Socket> {

        Context context = null;
        Socket socket = null;

        HadesNetworkThread(Context context) {
            this.context = context;
        }

        Socket connectToHadesServer(String hostname, int port) {
            Socket sock = null;
            try {
                InetAddress addr = Inet4Address.getByName(hostname);
                sock = new Socket(addr, port);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return sock;
        }

        void networkToast(final String str) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
                }
            });
        }

        @Override
        protected Socket doInBackground(String... strings) {
            if ((socket = connectToHadesServer("111.93.109.66", 12300)) == null) {
                networkToast("Cannot connect to Hades server");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        fab.setEnabled(true);
                    }
                });
                cancel(true);
                return null;
            } else {
                networkToast("Connected to Hades server 111.93.109.66");
            }

            try {
                socket.getOutputStream().write("CON_REQ".getBytes());
                byte[] br = new byte[7];
                if (socket.getInputStream().read(br) < 0)

                    if (String.valueOf(br).equals("CON_ACK")) {
                        networkToast("Connection Acknowledged");
                    } else {
                        networkToast("Connection discarded, still holding line anyway");
                    }
            } catch (IOException e) {
                e.printStackTrace();
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    fab.setEnabled(true);
                }
            });
            return null;
        }
    }

}

