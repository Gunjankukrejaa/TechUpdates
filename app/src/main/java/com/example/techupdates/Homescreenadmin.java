package com.example.techupdates;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Homescreenadmin extends AppCompatActivity {

    Button itsecad, machinead, startupad, bussadm, jobsad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreenadmin);

        itsecad = findViewById(R.id.itsectoradmin);
        machinead = findViewById(R.id.machineryadmin);
        startupad = findViewById(R.id.startupsaadmin);
        bussadm = findViewById(R.id.businessadmin);
        jobsad = findViewById(R.id.recruitementsadmin);

        itsecad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new Itsectoradmin();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.homescreen,fragment).commit();
            }
        });

        machinead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment1 = new machineryadmin();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.homescreen,fragment1).commit();
            }
        });

        startupad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment2 = new startups();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.homescreen,fragment2).commit();
            }
        });

        bussadm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment3 = new businessadmin();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.homescreen,fragment3).commit();
            }
        });

        jobsad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment4 = new recruitementsadmin();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.homescreen,fragment4).commit();
            }
        });
    }
}