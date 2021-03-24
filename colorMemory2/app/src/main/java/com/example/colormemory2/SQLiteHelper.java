package com.example.colormemory2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    public static String BDD_NAME = "GamersBDD", TABLE_NAME = "Gamers", ID = "id";
    public static String PSEUDO = "pseudo", LOGIN = "login", PASSWORD = "password", SCORE = "score";

    public SQLiteHelper(@Nullable Context context) {
        super(context, BDD_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql =
                "CREATE TABLE " + TABLE_NAME + " (" +
                        ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        PSEUDO + " TEXT NOT NULL," +
                        LOGIN + " TEXT NOT NULL," +
                        PASSWORD + " TEXT NOT NULL," +
                        SCORE + " INTEGER)";
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    boolean addUser(String pseudo, String login, String password, int score) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues data = new ContentValues();
        data.put(PSEUDO, pseudo);
        data.put(LOGIN, login);
        data.put(PASSWORD, password);
        data.put(SCORE, score);

        long res = db.insert(TABLE_NAME, null, data);
        if (res != -1) {
            return true;
        } else
            return false;
    }

    boolean connected(String login, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * FROM Gamers WHERE login='" + login + "' AND password='" + password + "'";
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            return true;
        } else
            return false;

    }

    String getUsername(String login, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT pseudo FROM Gamers WHERE login='" + login + "' AND password='" + password + "'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            String username = cursor.getString(0);
            return username;
        } else
            return null;
    }

    String getScore(String login, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT score FROM Gamers WHERE login='" + login + "' AND password='" + password + "'";
        Cursor cursor = db.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            String score = cursor.getString(0);;
            return score;
        } else
            return null;
    }


    Cursor viewData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM Gamers ORDER BY score DESC";
        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }



}
