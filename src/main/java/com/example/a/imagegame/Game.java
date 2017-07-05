package com.example.a.imagegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Game extends AppCompatActivity implements View.OnClickListener {
Button strt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        strt= (Button) findViewById(R.id.button4);
        strt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent it=new Intent(this,Match.class);
        startActivity(it);

    }
}
