package com.example.classapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.text.MessageFormat;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static String TABLE_NAMME = "user_data";
    private static String COLUMN_NAME1 = "name";
    private static String COLUMN_NAME2 = "age";
    private static String COLUMN_NAME3 = "email";

    public DatabaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = MessageFormat.format("CREATE TABLE {0}({1} TEXT, {2} TEXT, {3} TEXT)", TABLE_NAMME, COLUMN_NAME1, COLUMN_NAME2, COLUMN_NAME3);
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    long addData(String name, int age, String email) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME1, name);
        values.put(COLUMN_NAME2, age);
        values.put(COLUMN_NAME3, email);
//        String query = MessageFormat.format("INSERT INTO {0} VALUES({1}, {2}, {3})", TABLE_NAMME, name, age, email);
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
//        sqLiteDatabase.execSQL(query);
        return sqLiteDatabase.insert(TABLE_NAMME, null, values);
    }

    int delete(String email) {
        SQLiteDatabase db = getWritableDatabase();
        return db.delete(TABLE_NAMME, "email=?", new String[] {email});
    }

    int update (String originalName, String name) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME1, name);
        return db.update(TABLE_NAMME, values, "name=?", new String[] {originalName});
    }
    Cursor getData() {
        String query = MessageFormat.format("SELECT * FROM {0}", TABLE_NAMME);
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery(query, null);
    }
}