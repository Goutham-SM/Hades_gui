package com.goutham.hades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;


public class MainActivity extends Activity implements View.OnClickListener {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

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

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.button1:
                // do your code
                Log.i("clicks","You Clicked B1");
                Intent i=new Intent(MainActivity.this, MainActivity2.class);
                startActivity(i);
                break;

            case R.id.button2:
                // do your code
                Log.i("clicks","You Clicked B2");
                Intent t=new Intent(MainActivity.this, MainActivity2.class);
                startActivity(t);
                break;
            case R.id.button3:
                // do your code
                Log.i("clicks","You Clicked B3");
                Intent j=new Intent(MainActivity.this, MainActivity2.class);
                startActivity(j);
                break;
            case R.id.button4:
                // do your code
                Log.i("clicks","You Clicked B4");
                Intent k=new Intent(MainActivity.this, MainActivity2.class);
                startActivity(k);
                break;
            case R.id.button6:
                // do your code
                Log.i("clicks","You Clicked B5");
                Intent l=new Intent(MainActivity.this, MainActivity2.class);
                startActivity(l);
                break;
            case R.id.button7:
                // do your code
                Log.i("clicks","You Clicked B6");
                Intent m=new Intent(MainActivity.this, MainActivity2.class);
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
    }

