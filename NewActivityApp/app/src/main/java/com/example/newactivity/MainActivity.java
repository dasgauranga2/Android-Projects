 package com.example.newactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

 public class MainActivity extends AppCompatActivity {

    public void next(View view) {
        // create an intent to launch another activity
        // in the second argument we specify the activity we want to launch
        Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
        // add data to the intent
        // we can access this data from the activity that we will launch
        // the first argument is the name of the data
        // the second argument is the actual data we want to send
        intent.putExtra("NAME","Gauranga Das");
        // launch the new activity
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // First go to File->New->Activity->Gallery
        // Select an activity
    }
}