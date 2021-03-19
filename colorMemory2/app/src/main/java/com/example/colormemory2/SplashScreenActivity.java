package com.example.colormemory2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash_screen);

        Runnable run = new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(getApplicationContext(), Connection.class);
                startActivity(intent);
                finish();
            }
        };

        new Handler().postDelayed(run, 3000);

    }
}