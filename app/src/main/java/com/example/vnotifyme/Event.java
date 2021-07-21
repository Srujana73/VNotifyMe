package com.example.vnotifyme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.CalendarContract;
import android.view.View;

public class Event extends SQLiteOpenHelper{

    public static final String  DBNAME = "Event.db";
    public static final String TAG = "Event";
    public static final String COL1 = "eventid";
    public static final String COL2 = "eventname";
    public static final String COL3 = "clubname";
    public static final String COL4 = "date";
    public static final String COL5 = "venue";
    public static final String COL6 = "time";

    public Event(Context context) {
        super(context, "Event", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDB) {
        MyDB.execSQL("create Table Events(eventid TEXT primary key, eventname TEXT, clubname TEXT, date TEXT, venue TEXT, time TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDB, int oldVersion, int newVersion) {
        MyDB.execSQL("drop Table if exists Events");
    }

    public Boolean insertDataEvent(String eventid, String eventname, String clubname, String date, String venue, String time) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("eventid", eventid);
        contentValues.put("eventname", eventname);
        contentValues.put("clubname", clubname);
        contentValues.put("date", date);
        contentValues.put("venue", venue);
        contentValues.put("time", time);
        long result = MyDB.insert("Events", null, contentValues);
        if (result == -1) return false;
        else
            return true;
    }

    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM Events";
        Cursor data = db.rawQuery(query, null);
        return data;
    }

    public void deleteRecord(String eventid){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM Events WHERE " + COL1 + " = '" + eventid + "'";
        db.execSQL(query);
    }

}

