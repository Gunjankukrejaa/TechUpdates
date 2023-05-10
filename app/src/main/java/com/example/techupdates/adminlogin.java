package com.example.techupdates;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class adminlogin extends AppCompatActivity {

    Button proceed;
    EditText adminid;
    String idadmin = "admin123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminlogin);

        proceed = findViewById(R.id.adlogin);
        adminid = findViewById(R.id.adminidno);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performproceed();
            }
        });
    }

    private void performproceed() {

        String adid = adminid.getText().toString();

        if(adid.equals(idadmin)){
            Intent intent=new Intent(adminlogin.this,Homescreenadmin.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(adminlogin.this,"Enter valid admin id",Toast.LENGTH_LONG).show();
        }
    }
}