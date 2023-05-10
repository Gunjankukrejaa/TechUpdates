package com.example.techupdates;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class itsector extends Fragment {
        TextView title,content;
        Button read;

    FirebaseDatabase mfirebaseDatabase;

    DatabaseReference databaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_itsectoradmin,container,false);

        title = view.findViewById(R.id.headline);
        content = view.findViewById(R.id.text);
        read = view.findViewById(R.id.getnews);

        mfirebaseDatabase = FirebaseDatabase.getInstance();

        return view;
    }

}