package com.example.vnotifyme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EventWinners extends AppCompatActivity {

    EditText eventId, RegNo, Name, Year, Branch, Section, Position;
    Button RegisterForEvent;
    Winners DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_winners);


        eventId = (EditText) findViewById(R.id.eventId);
        Name = (EditText) findViewById(R.id.Name);
        RegNo = (EditText) findViewById(R.id.regNo);
        Year = (EditText) findViewById(R.id.Year);
        Branch = (EditText) findViewById(R.id.Branch);
        Section = (EditText) findViewById(R.id.Section);
        Position = (EditText) findViewById(R.id.pos);
        RegisterForEvent = (Button) findViewById(R.id.btnRegForEvent);
        DB = new Winners(this);

        RegisterForEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = eventId.getText().toString();
                String name = Name.getText().toString();
                String regno = RegNo.getText().toString();
                String year = Year.getText().toString();
                String branch = Branch.getText().toString();
                String section = Section.getText().toString();
                String pos = Position.getText().toString();


                if(ID.equals("")||name.equals("")||regno.equals("")||year.equals("")||branch.equals("")||section.equals("")||pos.equals(""))
                    Toast.makeText(EventWinners.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean insert = DB.addData(regno, name, year, branch, section, ID, pos);
                    if(insert==true) {
                        Toast.makeText(EventWinners.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(EventWinners.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}