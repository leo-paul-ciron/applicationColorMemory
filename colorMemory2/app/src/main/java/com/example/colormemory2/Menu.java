package com.example.colormemory2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    TextView user, score;
    Button how_play, ranked, easy_btn, hard_btn;
    SQLiteHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_layout);

        user = findViewById(R.id.firstname_menu);
        score = findViewById(R.id.score_menu);
        easy_btn = findViewById(R.id.btn_facile);
        hard_btn = findViewById(R.id.btn_expert2);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        user.setText(username);

        String score_user = intent.getStringExtra("score");
        score.setText(score_user);

        how_play = findViewById(R.id.btn_howplay);

        how_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Menu.this, How_play.class);
                startActivity(intent);
            }
        });

        ranked = findViewById(R.id.btn_ranked);


        ranked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Menu.this, Ranked.class);
                startActivity(intent);
            }
        });

        easy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, ModeFacile.class);
                startActivity(intent);
            }
        });

        hard_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, ModeDifficile.class);
                startActivity(intent);
            }
        });




    }

}