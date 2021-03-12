package com.gauranga.drawing;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.luciferx86.doodlecanvaslibrary.DoodleCanvas;

// GITHUB PROJECT LINK - https://github.com/Luciferx86/DoodleCanvasLibrary
public class MainActivity extends AppCompatActivity {

    DoodleCanvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add the gradle dependencies to both the gradle files
        // add the canvas view to the layout resource file
        // set a background for the canvas view if required

        // get the canvas view
        canvas = findViewById(R.id.doodleCanvas);
        // set the color
        canvas.setStrokeColor(Color.BLUE);
        // set the stroke width
        canvas.setStrokeWidth(5);
        // refer to the github project link for more properties
    }

    // get the image bitmap of the canvas view
    public void set_image(View view) {
        ImageView image = (ImageView) view;
        // create the bitmap
        Bitmap bitmap = Bitmap.createBitmap(canvas.getMeasuredWidth(), canvas.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        // create another canvas object
        Canvas c = new Canvas(bitmap);
        // draw the canvas view
        canvas.draw(c);
        // set the image view
        image.setImageBitmap(bitmap);
    }
}