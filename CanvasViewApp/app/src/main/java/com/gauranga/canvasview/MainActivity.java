package com.gauranga.canvasview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

// GITHUB PROJECT LINK  - https://github.com/Korilakkuma/CanvasView
public class MainActivity extends AppCompatActivity {

    CanvasView canvas;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create a new class 'CanvasView.java' and copy the code from this project
        // add the canvas view to the layout resource file

        // select the canvas view
        canvas = findViewById(R.id.canvas);

        // set the stroke color
        canvas.setPaintStrokeColor(Color.BLUE);
        // set the stroke width
        canvas.setPaintStrokeWidth(8);
        // set the background
        Bitmap bg_bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.hsr2);
        canvas.drawBitmap(bg_bitmap);
        // see github project for more properties
    }

    public void set_image(View view) {

        ImageView image = (ImageView) view;
        // get bitmap image from canvas
        Bitmap bitmap = canvas.getBitmap();
        image.setImageBitmap(bitmap);
    }
}