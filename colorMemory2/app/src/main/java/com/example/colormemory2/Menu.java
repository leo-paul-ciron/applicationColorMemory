package com.example.colormemory2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    TextView user, score;
    SQLiteHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        user = findViewById(R.id.firstname_menu);
        score = findViewById(R.id.score_menu);



        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        user.setText(username);

        String score_user = intent.getStringExtra("score");
        score.setText(score_user);
    }
}