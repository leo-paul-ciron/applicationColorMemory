package com.example.colormemory2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Connection extends AppCompatActivity {

    EditText email, pwd;
    Button connect, register;
    SQLiteHelper db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        email=findViewById(R.id.email_connection);
        pwd=findViewById(R.id.pwd_connection);
        connect=findViewById(R.id.btn_connect);
        register=findViewById(R.id.btn_link_register);
        db=new SQLiteHelper(getApplicationContext());




        connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(db.connected(email.getText().toString(), pwd.getText().toString())){

                    Intent intent = new Intent(Connection.this, Menu.class);
                    String username = db.getUsername(email.getText().toString(), pwd.getText().toString());
                    String score = db.getScore(email.getText().toString(), pwd.getText().toString());
                    intent.putExtra("username", username);
                    intent.putExtra("score","Score: " + score);
                    startActivity(intent);


                }
                else{
                    Toast.makeText(Connection.this, "Email ou mot de passe incorrect", Toast.LENGTH_SHORT).show();
                }

            }
        });



        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Connection.this, Register.class);
                startActivity(intent);
            }
        });



    }

}