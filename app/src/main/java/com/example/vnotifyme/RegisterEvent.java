package com.example.vnotifyme;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;

public class RegisterEvent extends AppCompatActivity {

    EditText eventid, eventname, clubname, date, venue, time;
    Button RegisterEvent, delete;
    Event DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_event);

        eventid = (EditText) findViewById(R.id.eventid);
        eventname = (EditText) findViewById(R.id.eventname);
        clubname = (EditText) findViewById(R.id.Eclubname);
        date = (EditText) findViewById(R.id.date);
        venue = (EditText) findViewById(R.id.venue);
        time = (EditText) findViewById(R.id.time);
        RegisterEvent = (Button) findViewById(R.id.btnReg);
        delete = (Button) findViewById(R.id.btndel);
        DB = new Event(this);

        RegisterEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = eventid.getText().toString();
                String name = eventname.getText().toString();
                String club = clubname.getText().toString();
                String edate = date.getText().toString();
                String evenue = venue.getText().toString();
                String etime = time.getText().toString();


                if(ID.equals("")||name.equals("")||club.equals("")||edate.equals("")||evenue.equals("")||etime.equals(""))
                    Toast.makeText(RegisterEvent.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean insert = DB.insertDataEvent(ID, name, club, edate, evenue, etime);
                    if(insert==true) {
                        Toast.makeText(RegisterEvent.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(RegisterEvent.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = eventid.getText().toString();
                if(ID.equals(""))
                    Toast.makeText(RegisterEvent.this, "Please enter the event ID", Toast.LENGTH_SHORT).show();
                else {
                    DB.deleteRecord(ID);
                    Toast.makeText(RegisterEvent.this, "Successfully deleted", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}