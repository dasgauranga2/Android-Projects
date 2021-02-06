package com.example.adaptiveicon;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Go to File->New->Image Asset
        // Set the foreground and background and then create the asset
        // The icon is saved in the mipmap folder
        // Go to 'AndroidManifest.xml' file
        // Set the 'icon' and 'roundIcon' attribute
    }
}