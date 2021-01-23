package com.example.fbuserauthentication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    Button login;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // button for user login
        login = findViewById(R.id.loginuserButton);
        // text input field for entering email
        email = findViewById(R.id.emailuserInput);
        // text input field for entering password
        password = findViewById(R.id.passworduserInput);

        // detect button click
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // USER LOGIN
                // get email from user input
                String email_text = email.getText().toString();
                // get password from user input
                String password_text = password.getText().toString();

                // function for user login
                loginUser(email_text, password_text);

                // USER LOGOUT
                // To logout users just run the below line
                //FirebaseAuth.getInstance().signOut();
            }
        });
    }

    private void loginUser(String email_text, String password_text) {
        // create authentication variable
        auth = FirebaseAuth.getInstance();
        // login the user using email and password
        // add a listener for successful login
        auth.signInWithEmailAndPassword(email_text,password_text).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(LoginActivity.this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show();
            }
        });
    }
}