package com.example.lttbdttuan7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DataUser extends SQLiteOpenHelper {
    public DataUser(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql =
                        "CREATE TABLE user ("+
                "id INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "name TEXT NOT NULL)";
        sqLiteDatabase.execSQL(sql);
    }

    public  void addUser(User user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put ("name", user.getName ());
        db.insert(  "user",  null, values);
    }
    public List<User> getAllUser(){
        List<User> list = new ArrayList<>();
        String sql ="Select * From user";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                User user = new User();
                user.setId(cursor.getInt(0));
                user.setName(cursor.getString(1));
                list.add(user);

            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }
    public int removeUser(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        return db.delete("User","ID =?",new String[]{String.valueOf(id)});

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
