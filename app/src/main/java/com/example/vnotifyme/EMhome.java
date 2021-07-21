package com.example.vnotifyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EMhome extends AppCompatActivity {

    Button EReg, Reg, Eve, win;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emhome);

        EReg = (Button) findViewById(R.id.btnEReg);

        Reg = (Button) findViewById(R.id.btnReg);

        Eve = (Button) findViewById(R.id.btneve);

        win = (Button) findViewById(R.id.btnwin);

        EReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RegisterEvent.class);
                startActivity(intent);
            }
        });

        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ParticipantsList.class);
                startActivity(intent);
            }
        });

        Eve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EventsList.class);
                startActivity(intent);
            }
        });


        win.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EventWinners.class);
                startActivity(intent);
            }
        });
        

    }
}