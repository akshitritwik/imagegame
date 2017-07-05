package com.example.a.imagegame;

import android.app.Service;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Intent i,item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //b= (Button) findViewById(R.id.button);
    }
    public void start(View v)
    {
        i=new Intent(this, MyService.class);
        item=new Intent(this,Game.class);
        startService(i);
        startActivity(item);
    }
    public void exit(View v)
    {
        android.os.Process.killProcess(android.os.Process.myPid());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stopService(i);
    }
}
