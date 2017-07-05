package com.example.a.imagegame;

import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Match extends AppCompatActivity {
    TextView tv1,tv2;
    Button m,nm;
    int sc=0;
    AlertDialog.Builder adb;
    private int[] photos=new int[]{R.drawable.deer,R.drawable.elephant,R.drawable.hyena,R.drawable.lion,R.drawable.polarbear};
    ImageView iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match);
        tv1= (TextView) findViewById(R.id.textView);
        tv2= (TextView) findViewById(R.id.textView2);
        m= (Button) findViewById(R.id.button7);
        nm= (Button) findViewById(R.id.button6);
        iv= (ImageView) findViewById(R.id.imageView2);
        nextimage();
        adb=new AlertDialog.Builder(this);

        new CountDownTimer(60000,1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                tv1.setText("seconds remaining" + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                tv1.setText("Time up!");
                AlertDialog alertDialog;
                alertDialog=new AlertDialog.Builder(Match.this).create();
                alertDialog.setTitle("Oops");
                alertDialog.setMessage("eee");
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Quit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });alertDialog.show();
            }
        }.start();

    }

    private void nextimage() {
        Random rand=new Random();
        int rdint=rand.nextInt(photos.length);
        iv.setImageResource(photos[rdint]);

    }
    public void match(View v)
    {
        if(iv.getDrawable().getConstantState().equals((getResources().getDrawable(R.drawable.deer).getConstantState())))
        {
            nextimage();
            sc++;
            tv2.setText(Integer.toString(sc));
        }
        else
        {
//moveTaskToBack(true);
            //finish();
            adb.setTitle("Game over");
            adb.setMessage("Score is" +sc);
            adb.setCancelable(false);
            adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
               dialog.cancel();
                }
            });
            adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
               finish();
                }
            });adb.show();
        }
    }
    public void nomatch1()
    {
        if(iv.getDrawable().getConstantState().equals((getResources().getDrawable(R.drawable.deer).getConstantState())))
        {
adb.setTitle("Game over");
            adb.setMessage("Score is"+sc);
            adb.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
               dialog.cancel();
                }
            });
            adb.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });adb.show();
        }
        else
        {
            nextimage();
            sc++;
            tv2.setText(Integer.toString(sc));
        }


    }
}
