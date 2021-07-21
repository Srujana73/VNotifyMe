package com.example.vnotifyme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;
import android.widget.Toast;


public class StudReg extends AppCompatActivity {


    EditText username, password, repassword, name, regno, emailid, mobileno, clubname;
    Button signup, signupEM;
    DBHelper DB;
    EMDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud_reg);

        username = (EditText) findViewById(R.id.username);
        name = (EditText) findViewById(R.id.name);
        regno = (EditText) findViewById(R.id.regno);
        emailid = (EditText) findViewById(R.id.emailid);
        mobileno = (EditText) findViewById(R.id.mobileno);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        clubname = (EditText) findViewById(R.id.clubname);
        signup = (Button) findViewById(R.id.btnsignup);
        signupEM = (Button) findViewById(R.id.btnsignupEM);
        DB = new DBHelper(this);
        db = new EMDB(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sname = name.getText().toString();
                String user = username.getText().toString();
                String regnum = regno.getText().toString();
                String mailid = emailid.getText().toString();
                String mobno = mobileno.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if (user.equals("") || pass.equals("") || repass.equals("") || sname.equals("") || regnum.equals("") || mailid.equals("") || mobno.equals(""))
                    Toast.makeText(StudReg.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else {
                    if (pass.equals(repass)) {
                        Boolean checkuser = DB.checkusername(user);
                        if (checkuser == false) {
                            Boolean insert = DB.insertData(user, pass, sname, regnum, mailid, mobno);
                            if (insert == true) {
                                Toast.makeText(StudReg.this, "Registered successfully as student", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), StudHome.class);
                                startActivity(intent);
                            } else {
                                Toast.makeText(StudReg.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(StudReg.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(StudReg.this, "Passwords are not same", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signupEM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sname = name.getText().toString();
                String user = username.getText().toString();
                String regnum = regno.getText().toString();
                String mailid = emailid.getText().toString();
                String mobno = mobileno.getText().toString();
                String club = clubname.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals("")||sname.equals("")||regnum.equals("")||mailid.equals("")||mobno.equals("")||club.equals(""))
                    Toast.makeText(StudReg.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)) {
                        Boolean checkuser = db.checkusernameEM(user);
                        if(checkuser==false) {
                            Boolean insert = db.insertDataEM(user, pass, sname, regnum, mailid, mobno, club);
                            if(insert==true) {
                                Toast.makeText(StudReg.this, "Registered successfully as event manager", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), EMhome.class);
                                startActivity(intent);
                            }else {
                                Toast.makeText(StudReg.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(StudReg.this, "User already exists! please sign in", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(StudReg.this, "Passwords are not same", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}
