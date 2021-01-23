package com.example.fbuserauthentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    EditText email,password;
    Button signup;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Go to Tools->Firebase
        // Go to Authentication and select 'Authenticate using Google Sign-In'
        // Select 'Add the Firebase Authentication SDK' and accept changes

        // input field for entering email
        email = findViewById(R.id.emailInput);
        // input field for entering password
        password = findViewById(R.id.passwordInput);
        // select button for user signup
        signup = findViewById(R.id.signupuserButton);

        // detect button click
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get the email from user input
                String email_text = email.getText().toString();
                // get the password from user input
                String password_text = password.getText().toString();

                // function to register the user
                // we pass the email and password as arguments
                registerUser(email_text,password_text);
            }
        });
    }

    private void registerUser(String email_text, String password_text) {
        // create authentication variable
        auth = FirebaseAuth.getInstance();
        // create the user using email and password
        auth.createUserWithEmailAndPassword(email_text,password_text).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                // check if user signup is successful
                if (task.isSuccessful()) {
                    Toast.makeText(RegisterActivity.this, "USER SIGNUP SUCCESSFUL", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(RegisterActivity.this, "USER SIGNUP FAILED", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}