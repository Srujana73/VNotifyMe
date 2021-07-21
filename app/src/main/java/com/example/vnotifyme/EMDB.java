package com.example.vnotifyme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.Nullable;

public class EMDB extends SQLiteOpenHelper{

    public static final String  DBNAME = "EventManager.db";
    public static final String TAG = "EventManager";
    public static final String COL1 = "username";
    public static final String COL2 = "password";
    public static final String COL3 = "name";
    public static final String COL4 = "regno";
    public static final String COL5 = "emailid";
    public static final String COL6 = "mobileno";
    public static final String COL7 = "clubname";

    public EMDB(Context context) {
        super(context, "EventManager", null, 1);
    }


    @Override

    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table EMusers(username TEXT , password TEXT, name TEXT, regno TEXT, emailid TEXT, mobileno TEXT, clubname TEXT, primary key(username, clubname))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists EMusers");
    }

    public Boolean insertDataEM(String username, String password, String name, String regno, String emailid, String mobileno, String clubname) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        contentValues.put("name", name);
        contentValues.put("regno", regno);
        contentValues.put("emailid", emailid);
        contentValues.put("mobileno", mobileno);
        contentValues.put("clubname", clubname);
        long result = MyDB.insert("EMusers", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public Boolean checkusernameEM(String username) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from EMusers where username = ?", new String[] {username});
        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }

    public Boolean checkusernamepasswordEM(String username, String password) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from EMusers where username = ? and password = ?", new String[] {username, password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;

    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM EMusers";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void cancelReg(String username, String clubname){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM EMusers WHERE " + COL1 + " = '" + username + "'" + " AND " + COL7 + " = '" + clubname + "'";
        db.execSQL(query);
    }

}

