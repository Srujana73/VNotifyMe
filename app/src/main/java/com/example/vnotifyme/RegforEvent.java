package com.example.vnotifyme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegforEvent extends AppCompatActivity {

    EditText eventId, RegNo, Name, Year, Branch, Section;
    Button RegisterForEvent, UndoReg;
    Participants DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regfor_event);


        eventId = (EditText) findViewById(R.id.eventId);
        Name = (EditText) findViewById(R.id.Name);
        RegNo = (EditText) findViewById(R.id.regNo);
        Year = (EditText) findViewById(R.id.Year);
        Branch = (EditText) findViewById(R.id.Branch);
        Section = (EditText) findViewById(R.id.Section);
        RegisterForEvent = (Button) findViewById(R.id.btnRegForEvent);
        UndoReg = (Button) findViewById(R.id.btnUndoReg);
        DB = new Participants(this);

        RegisterForEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = eventId.getText().toString();
                String name = Name.getText().toString();
                String regno = RegNo.getText().toString();
                String year = Year.getText().toString();
                String branch = Branch.getText().toString();
                String section = Section.getText().toString();


                if(ID.equals("")||name.equals("")||regno.equals("")||year.equals("")||branch.equals("")||section.equals(""))
                    Toast.makeText(RegforEvent.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean insert = DB.addData(regno, name, year, branch, section, ID);
                    if(insert==true) {
                        Toast.makeText(RegforEvent.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                    }else {
                        Toast.makeText(RegforEvent.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        UndoReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = eventId.getText().toString();
                String regno = RegNo.getText().toString();

                if(ID.equals("") || regno.equals(""))
                    Toast.makeText(RegforEvent.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    DB.undoReg(ID, regno);
                    Toast.makeText(RegforEvent.this, "Sucessfully removed", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}