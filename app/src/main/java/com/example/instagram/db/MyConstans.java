package com.example.instagram.db;

public class MyConstans {
    public static final String TABLE_NAME = "my_p";
    public static final String _ID = "_id";
    public static final String TEXT_IN_COMMENTS = "text_in";
    public static final String NAME_PR = "name";
    public static final String DB_NAME = "my_db.db";
    public static final int DB_VERSION = 2;
    public static final String TABLE_STRUCTURE = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + " (" + _ID + "INTEGER PRIMARY KEY," + TEXT_IN_COMMENTS +
            " TEXT," + NAME_PR + " TEXT)";
    public static final String DROP_TABLE = "DROP TABLE OF EXISTS" + TABLE_NAME;
}
