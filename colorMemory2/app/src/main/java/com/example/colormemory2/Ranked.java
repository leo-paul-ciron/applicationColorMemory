package com.example.colormemory2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Ranked extends AppCompatActivity {

    ArrayList<String> listItem;
    ArrayAdapter adapter;
    SQLiteHelper db;

    ListView userlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ranked);

        db=new SQLiteHelper(getApplicationContext());

        listItem = new ArrayList<>();

        userlist = findViewById(R.id.ListUsers);

        viewData();

        userlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String text = userlist.getItemAtPosition(position).toString();
                Toast.makeText(Ranked.this, ""+text, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void viewData() {
        Cursor cursor = db.viewData();
        int i=0;

        if(cursor.getCount() == 0){
            Toast.makeText(this, "pas de joueur", Toast.LENGTH_SHORT).show();
        } else{
            while(cursor.moveToNext()){
                i++;
                listItem.add("Position " + i + "\nJoueur : " + cursor.getString(1) + "\nScore : " + cursor.getString(4));
            }

            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItem);
            userlist.setAdapter(adapter);
        }
    }


}