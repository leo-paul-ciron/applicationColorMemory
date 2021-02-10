package com.example.colormemory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button easyLevelButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        easyLevelButton =findViewById(R.id.ButtonLevelEasy);
        easyLevelButton.setOnClickListener(
                (view)->{reactionAuClickEasylevelButton();}
        );
    }

    private void reactionAuClickEasylevelButton() {
        Intent easyLevel = new Intent(MainActivity.this, EasyLevel.class);
        startActivity(easyLevel);

    }
}