package com.gauranga.snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    // function is called when the button is clicked
    public void click(View view) {
        // create a snackbar
        // first parameter is the view which refers to the button
        // second parameter is the message displayed in the snackbar
        // third parameter defines how long the message will be displayed
        Snackbar snackbar = Snackbar.make(view, "BUTTON CLICKED", Snackbar.LENGTH_INDEFINITE);
        // we can also add a clickable link in the snackbar
        // first parameter is the link text
        // second parameter defines a function which will be executed
        // when the link is clicked
        snackbar.setAction("EXIT", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Do something
            }
        });
        // show the snackbar
        snackbar.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Add the Google Material Design dependency
        // Go to the manifest file and set the theme as 'Theme.MaterialComponents.Light.NoActionBar'
    }
}