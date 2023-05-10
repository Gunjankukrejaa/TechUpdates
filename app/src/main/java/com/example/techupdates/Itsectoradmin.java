package com.example.techupdates;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Itsectoradmin extends Fragment {

    private EditText title, content;
    private Button savedata;

    FirebaseDatabase mfirebaseDatabase;

    DatabaseReference databaseReference;

    info info;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_itsectoradmin,container,false);

        title = view.findViewById(R.id.headlineadmin);
        content = view.findViewById(R.id.textadmin);
        savedata = view.findViewById(R.id.save);





        mfirebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference =mfirebaseDatabase.getReference("info");



        info=new info();


        savedata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title1 = title.getText().toString();
                String content1 = content.getText().toString();

                info.setTitle(title1);
                info.setContent(content1);
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.setValue(info);
                        Toast.makeText(getContext(), "data added", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getContext(), "Fail to add data " + error, Toast.LENGTH_SHORT).show();
                    }
                });
            }

        });
        return view;
    }
}