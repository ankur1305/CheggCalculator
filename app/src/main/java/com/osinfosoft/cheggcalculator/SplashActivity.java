package com.osinfosoft.cheggcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        int SPLASH_SCREEN_TIME_OUT = 2000;
        new Handler().postDelayed(() -> {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }, SPLASH_SCREEN_TIME_OUT);
    }
}