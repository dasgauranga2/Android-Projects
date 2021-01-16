package com.example.images;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public void change_img(View view) {
        // select the image view
        ImageView image = (ImageView) findViewById(R.id.imageView);
        // change the image
        image.setImageResource(R.drawable.hsr2);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}