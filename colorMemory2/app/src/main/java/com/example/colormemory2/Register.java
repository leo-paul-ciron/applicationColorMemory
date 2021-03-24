package com.example.colormemory2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    EditText name, email, pwd;
    Button register;
    SQLiteHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name=findViewById(R.id.pseudo_register);
        email=findViewById(R.id.email_register);
        pwd=findViewById(R.id.pwd_register);
        register=findViewById(R.id.btn_register);

        db=new SQLiteHelper(getApplicationContext());

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().equals("") || email.getText().toString().equals("") || pwd.getText().toString().equals("")) {
                    Toast.makeText(Register.this, "Vous avez oublié d'inscrire des données", Toast.LENGTH_SHORT).show();
                }
                else if(db.addUser(name.getText().toString(), email.getText().toString(), pwd.getText().toString(), 0)){
                    Intent intent = new Intent(Register.this, Connection.class);
                    startActivity(intent);
                }
            }
        });
    }
}