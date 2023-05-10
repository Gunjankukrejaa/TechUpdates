package com.example.techupdates;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {
    Button userlogin, usersignup, adminlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        userlogin = findViewById(R.id.loginuser);
        usersignup = findViewById(R.id.signupuser);
        adminlogin = findViewById(R.id.loginadmin);

        userlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this,Login.class);
                startActivity(intent);
            }
        });

        usersignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this,Signin.class);
                startActivity(intent);
            }
        });

        adminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this,adminlogin.class);
                startActivity(intent);
            }
        });
    }
}