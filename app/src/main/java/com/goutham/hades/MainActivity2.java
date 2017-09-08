package com.goutham.hades;

/*
 * Created by Goutham on 08-09-2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class MainActivity2 extends Activity implements  View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calling_page1);
        Button btn = (Button) findViewById(R.id.but4);
        btn.setOnClickListener(this);
    }
    //@Override
    public void onClick(View v)
    {
        //Button btn=(Button) findViewById(R.id.but4);
        Intent i=new Intent(MainActivity2.this, MainActivity.class);
        startActivity(i);
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }*/
}