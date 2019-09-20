package com.example.myapplication;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    FrameLayout f = null;

    Handler handler = new Handler(){
        int i = 0;
        //处理

        @Override
        public void handleMessage(Message msg) {
            if(msg.what == 0x123){
                i++;
                setPic(i%8);
            }
            super.handleMessage(msg);
        }
    };

    void setPic(int i){
        Drawable s1 = getResources().getDrawable(R.drawable.s_1);
        Drawable s2 = getResources().getDrawable(R.drawable.s_2);
        Drawable s3 = getResources().getDrawable(R.drawable.s_3);
        Drawable s4 = getResources().getDrawable(R.drawable.s_4);
        Drawable s5 = getResources().getDrawable(R.drawable.s_5);
        Drawable s6 = getResources().getDrawable(R.drawable.s_6);
        Drawable s7 = getResources().getDrawable(R.drawable.s_7);
        Drawable s8 = getResources().getDrawable(R.drawable.s_8);

        switch (i){
            case 1:
                f.setForeground(s1);
                break;
            case 2:
                f.setForeground(s2);
                break;
            case 3:
                f.setForeground(s3);
                break;
            case 4:
                f.setForeground(s4);
                break;
            case 5:
                f.setForeground(s5);
                break;
            case 6:
                f.setForeground(s6);
                break;
            case 7:
                f.setForeground(s7);
                break;
            case 8:
                f.setForeground(s8);
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        f  = (FrameLayout) findViewById(R.id.mylayout);
        final MouseView mv = new MouseView(MainActivity.this);
        mv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mv.bitmapX = event.getX() - 150;
                mv.bitmapY = event.getY() - 150;
                mv.invalidate();
                return true;
            }
        });
        f.addView(mv);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0x123);
            }
        },0,170);

    }
}
