package com.example.easytao01.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.example.easytao01.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //1.5秒后跳转到主页
        Timer timer= new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                //跳转到主页
                Intent intent=new Intent();
                intent.setClass(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },1500);
    }
}
