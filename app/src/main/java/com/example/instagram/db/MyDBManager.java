package com.example.instagram.db;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class MyDBManager {
    private Context context;
    private MyDBHelper myDBHelper;
    private SQLiteDatabase db;
    public MyDBManager(Context context) {
        this.context = context;
        myDBHelper = new MyDBHelper(context);
    }
    public void openDB(){
        db = myDBHelper.getWritableDatabase();
    }
    public void insertToDB(String title, String name){
        ContentValues cv = new ContentValues();
        cv.put(MyConstans.TEXT_IN_COMMENTS, title);
        cv.put(MyConstans.NAME_PR, name);
        db.insert(MyConstans.TABLE_NAME, null,  cv);
    }
    public List<String>  readFromDB(){
        List <String> tempList = new ArrayList<>();
        Cursor cursor = db.query(MyConstans.TABLE_NAME,
                null, null,
                null, null,
                null, null );
        while (cursor.moveToNext()){
            @SuppressLint("Range")
            String title = cursor.getString(cursor.getColumnIndex(MyConstans.TEXT_IN_COMMENTS));
            tempList.add(title);
        }
        cursor.close();
        return tempList;
    }
    public void closeDB(){
        myDBHelper.close();
    }
}
