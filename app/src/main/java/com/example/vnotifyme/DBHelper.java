package com.example.vnotifyme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper{

    public static final String  DBNAME = "Login.db";
    public static final String TAG = "Login";
    public static final String COL1 = "username";
    public static final String COL2 = "password";
    public static final String COL3 = "name";
    public static final String COL4 = "regno";
    public static final String COL5 = "emailid";
    public static final String COL6 = "mobileno";

    public DBHelper(Context context) {
        super(context, "Login.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table users(username TEXT primary key, password TEXT, name TEXT, regno TEXT, emailid TEXT, mobileno TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists users");
    }

    public Boolean insertData(String username, String password, String name, String regno, String emailid, String mobileno) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("name", name);
        contentValues.put("regno", regno);
        contentValues.put("emailid", emailid);
        contentValues.put("mobileno", mobileno);
        long result = MyDB.insert("users", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean checkusername(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ?", new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }

    public Boolean checkusernamepassword(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username = ? and password = ?", new String[] {username, password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM users ORDER BY regno";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void CancelReg(String username){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM users WHERE " + COL1 + " = '" + username + "'" ;
        db.execSQL(query);
    }

}

