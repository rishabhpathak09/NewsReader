package com.example.rishabh.newsreader;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    public Database(Context con){
        super(con,"newsdb",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists articles (" +
                "id INTEGER PRIMARY KEY," +
                "articleid varchar(200)," +
                "title varchar(200)," +
                "content varchar(2000))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists articles");
        onCreate(db);
    }

    public void addData(String articleId,String title,String content){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select max(id) as max from articles",null);
        int id = 0;
        if(c.moveToFirst()){
            id  = c.getInt(0)+1;
        }
        else{
            id=0;
        }
        db = this.getWritableDatabase();
        ContentValues con = new ContentValues();
        con.put("id",id);
        con.put("articleid",articleId);
        con.put("title",title);
        con.put("content",content);

        db.insert("articles",null,con);
        db.close();
    }
    public ArrayList<String> getHeading(){
        ArrayList<String> arr = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select title from articles",null);
        if(c.moveToFirst()){
            do{
                arr.add(c.getString(0));
            }while(c.moveToNext());
        }
        return arr;
    }
    public ArrayList<String> getContent(){
        ArrayList<String> arr = new ArrayList<String>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select content from articles",null);
        if(c.moveToFirst()){
            do{
                arr.add(c.getString(0));
            }while(c.moveToNext());
        }
        return arr;
    }
}
