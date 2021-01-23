package com.example.fbuserauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button signup,login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Go to Tools->Firebase
        // Go to Analytics and click the link
        // Select to 'Connect to Firebase'
        // Select a project
        // Go Firebase website and then go to console
        // Select the project
        // Go to Authentication->Sign-In-Method
        // Select 'Email/Password' option and enable sign-in

        // button for signup
        signup = findViewById(R.id.signupButton);
        // button for login
        login = findViewById(R.id.loginButton);

        // detect button click
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // launch a new activity for signup
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });

        // detect button click
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // launch a new activity for login
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}