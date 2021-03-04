package com.gauranga.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    // launch the first fragment
    public void first_fragment(View view) {
        // create an object of the fragment class we want to display
        FragmentOne fragmentOne = new FragmentOne();
        // get the fragment transaction object
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // use transaction to display the fragment
        // first parameter is the id of the layout where the fragment will be displayed
        // second parameter is the fragment object
        transaction.replace(R.id.fragmentLayout, fragmentOne);
        transaction.commit();
    }

    // launch the second fragment
    public void second_fragment(View view) {
        // create an object of the fragment class we want to display
        FragmentTwo fragmentTwo = new FragmentTwo();
        // get the fragment transaction object
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        // use transaction to display the fragment
        // first parameter is the id of the layout where the fragment will be displayed
        // second parameter is the fragment object
        transaction.replace(R.id.fragmentLayout, fragmentTwo);
        transaction.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Right-click on the directory where the MainActivity.java is located
        // Got to New->Fragment->Fragment(Blank)
        // Create the fragment
        // Do all the coding for the fragment in the fragment class java file
        // Similarly add more fragments
    }
}