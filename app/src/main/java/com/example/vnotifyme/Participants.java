package com.example.vnotifyme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import androidx.annotation.Nullable;

public class Participants extends SQLiteOpenHelper{
    public static final String TAG = "Participants";

    public static final String DBNAME = "Participants";
    public static final String COL1 = "RegNo";
    public static final String COL2 = "Name";
    public static final String COL3 = "Year";
    public static final String COL4 = "Branch";
    public static final String COL5 = "Section";
    public static final String COL6 = "EventID";


    public Participants(Context context) {
        super(context, "Participants", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table participants(RegNo TEXT , Name TEXT,Year TEXT, Branch TEXT, Section TEXT, EventID TEXT, primary key(RegNo, EventID))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists participants");
    }

    public boolean addData(String RegNo, String Name, String Year, String Branch, String Section, String EventID){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("RegNo", RegNo);
        contentValues.put("Name", Name);
        contentValues.put("Year", Year);
        contentValues.put("Branch", Branch);
        contentValues.put("Section", Section);
        contentValues.put("EventID", EventID);
        long result = MyDB.insert("participants", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public Cursor getData(String EventID){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM participants WHERE " + COL6 + " = '" + EventID + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void undoReg(String EventID, String regno){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM participants WHERE " + COL6 + " = '" + EventID + "'" + " AND " + COL1 + " = '" + regno + "'";
        db.execSQL(query);
    }

}

