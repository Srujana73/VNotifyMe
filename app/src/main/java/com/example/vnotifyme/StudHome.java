package com.example.vnotifyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StudHome extends AppCompatActivity {

    Button SReg, eventsList, part, win;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud_home);


        SReg = (Button) findViewById(R.id.btnsreg);
        eventsList = (Button) findViewById(R.id.btneventlist);
        part = (Button) findViewById(R.id.btnpart);
        win = (Button) findViewById(R.id.btnwin);

        SReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegforEvent.class);
                startActivity(intent);
            }
        });


        part.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ParticipantsList.class);
                startActivity(intent);
            }
        });

        eventsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EventsList.class);
                startActivity(intent);
            }
        });

        win.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WinnersList.class);
                startActivity(intent);
            }
        });

    }
}