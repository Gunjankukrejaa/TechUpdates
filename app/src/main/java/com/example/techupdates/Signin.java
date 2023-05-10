package com.example.techupdates;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Signin extends AppCompatActivity {
    EditText email, password;
    Button signup;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;

    FirebaseAuth mAuth;
    FirebaseUser muser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        email=findViewById(R.id.email);
        password=findViewById(R.id.passs);
        signup=findViewById(R.id.signin);
        progressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        muser = mAuth.getCurrentUser();


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PerformAuth();
            }
        });
    }

    private void PerformAuth() {
        String emaill = email.getText().toString();
        String pass = password.getText().toString();



        if (!emaill.matches(emailPattern))
        {
            email.setError("Enter Connext Email");
        }else if(pass.isEmpty() || pass.length() <6)
        {
            password.setError("Enter Proper Password");
        } else {
            progressDialog.setMessage("Please Wait While Signing up...");
            progressDialog.setTitle("Sign up");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(emaill,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        sendusertonextactivity();
                        Toast.makeText(Signin.this, "Sign up successful",Toast.LENGTH_LONG);
                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(Signin.this,""+task.getException(),Toast.LENGTH_LONG).show();

                    }

                }
            });
        }


    }

    private void sendusertonextactivity() {
        Intent intent=new Intent(Signin.this,Homescreen.class);
        intent. setFlags (Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}