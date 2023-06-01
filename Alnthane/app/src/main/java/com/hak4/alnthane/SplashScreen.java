package com.hak4.alnthane;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends AppCompatActivity {
    private ImageView imege;
    private static int GECİSSURESİ=1500;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        imege=(ImageView) findViewById(R.id.imageView2);
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.animation);
        imege.startAnimation(animation);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent gecis=new Intent(SplashScreen.this,Giris.class);
                startActivity(gecis);
                finish();
            }
        },GECİSSURESİ);
    }
}