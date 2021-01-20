package com.example.newactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // create an intent to retrieve the data sent
        Intent intent = getIntent();
        // we access the data by specifying the name of the data
        String name = intent.getStringExtra("NAME");

        Toast.makeText(this,name,Toast.LENGTH_SHORT).show();
    }
}