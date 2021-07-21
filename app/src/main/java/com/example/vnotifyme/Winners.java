package com.example.vnotifyme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import androidx.annotation.Nullable;

public class Winners extends SQLiteOpenHelper{
    public static final String TAG = "Winners";

    public static final String DBNAME = "Winners";
    public static final String COL1 = "RegNo";
    public static final String COL2 = "Name";
    public static final String COL3 = "Year";
    public static final String COL4 = "Branch";
    public static final String COL5 = "Section";
    public static final String COL6 = "EventID";
    public static final String COL7 = "Position";


    public Winners(Context context) {
        super(context, "Winners", null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table winners(RegNo TEXT , Name TEXT,Year TEXT, Branch TEXT, Section TEXT, EventID TEXT, Position TEXT, primary key(RegNo, EventID))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists winners");
    }

    public boolean addData(String RegNo, String Name, String Year, String Branch, String Section, String EventID, String Position){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("RegNo", RegNo);
        contentValues.put("Name", Name);
        contentValues.put("Year", Year);
        contentValues.put("Branch", Branch);
        contentValues.put("Section", Section);
        contentValues.put("EventID", EventID);
        contentValues.put("Position", Position);
        long result = MyDB.insert("winners", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public Cursor getData(String EventID){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM winners WHERE " + COL6 + " = '" + EventID + "'" + "ORDER BY Position";
        Cursor data = db.rawQuery(query, null);
        return data;
    }


}

