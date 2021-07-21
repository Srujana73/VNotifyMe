package com.example.vnotifyme;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

public class WinnersList extends AppCompatActivity {

    EditText Eventid;
    Button show;
    Winners win;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winners_list);

        show = (Button) findViewById(R.id.btnshow);
        Eventid = (EditText) findViewById(R.id.EID);
        win = new Winners(this);



        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ID = Eventid.getText().toString();
                if(ID.equals(""))
                    Toast.makeText(WinnersList.this, "please, enter Event Id", Toast.LENGTH_SHORT).show();
                else
                    addtable();
            }
        });

    }

    public void addtable() {
        Eventid = (EditText) findViewById(R.id.EID);
        win = new Winners(this);
        String ID = Eventid.getText().toString();
        TableLayout partList = (TableLayout) findViewById(R.id.table_main);
        TableRow tbrow0 = new TableRow(this);
        TextView tv0 = new TextView(this);
        tv0.setText("      Position   ");
        tv0.setTextColor(Color.BLACK);
        tbrow0.addView(tv0);
        TextView tv1 = new TextView(this);
        tv1.setText("Reg.No   ");
        tv1.setTextColor(Color.BLACK);
        tbrow0.addView(tv1);
        TextView tv2 = new TextView(this);
        tv2.setText("Name   ");
        tv2.setTextColor(Color.BLACK);
        tbrow0.addView(tv2);
        TextView tv3 = new TextView(this);
        tv3.setText("Year   ");
        tv3.setTextColor(Color.BLACK);
        tbrow0.addView(tv3);
        TextView tv4 = new TextView(this);
        tv4.setText("Branch   ");
        tv4.setTextColor(Color.BLACK);
        tbrow0.addView(tv4);
        TextView tv5 = new TextView(this);
        tv5.setText("Section   ");
        tv5.setTextColor(Color.BLACK);
        tbrow0.addView(tv5);
        partList.addView(tbrow0);

        Cursor data = win.getData(ID);
        int i = 1;
        while(data.moveToNext()){
            TableRow tbrow = new TableRow(this);
            TextView t1v = new TextView(this);
            t1v.setText(" "+ i + "   ");
            t1v.setTextColor(Color.BLACK);
            t1v.setGravity(Gravity.CENTER);
            tbrow.addView(t1v);
            TextView t2v = new TextView(this);
            t2v.setText(data.getString(0)+ "   ");
            t2v.setTextColor(Color.BLACK);
            t2v.setGravity(Gravity.CENTER);
            tbrow.addView(t2v);
            TextView t3v = new TextView(this);
            t3v.setText(data.getString(1) + "   ");
            t3v.setTextColor(Color.BLACK);
            t3v.setGravity(Gravity.CENTER);
            tbrow.addView(t3v);
            TextView t4v = new TextView(this);
            t4v.setText(data.getString(2) + "   ");
            t4v.setTextColor(Color.BLACK);
            t4v.setGravity(Gravity.CENTER);
            tbrow.addView(t4v);
            TextView t5v = new TextView(this);
            t5v.setText(data.getString(3) + "   ");
            t5v.setTextColor(Color.BLACK);
            t5v.setGravity(Gravity.CENTER);
            tbrow.addView(t5v);
            TextView t6v = new TextView(this);
            t6v.setText(data.getString(4) + "   ");
            t6v.setTextColor(Color.BLACK);
            t6v.setGravity(Gravity.CENTER);
            tbrow.addView(t6v);
            i = i + 1;
            partList.addView(tbrow);
        }

    }

}