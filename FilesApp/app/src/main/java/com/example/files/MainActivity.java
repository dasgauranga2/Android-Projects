package com.example.files;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    private static final int IMAGE_REQUEST = 2;

    // save images
    public void save_image(View view) {
        // launch an intent to open the gallery
        Intent intent = new Intent();
        intent.setType("image/");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // check if the image was successfully retrieved
        if (requestCode == IMAGE_REQUEST && resultCode == RESULT_OK) {
            // get the image data in uri format
            Uri image_uri = data.getData();
            // get the image data in bitmap format
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), image_uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // set the image view
            image.setImageBitmap(bitmap);
            ///////////////////////////////////////////////////////////////////
            // SAVE THE IMAGE AS FILE
            ///////////////////////////////////////////////////////////////////
            ContextWrapper wrapper = new ContextWrapper(getApplicationContext());
            // directory where we will store the images
            // if it does not exists already a new one will be created
            // first parameter is the name of the directory
            // second parameter is the operating mode
            File file = wrapper.getDir("IMAGES",MODE_PRIVATE);
            // create a file where the image will be saved
            // first parameter is the path of the directory where the image will be stored
            // second parameter is image file name
            // the file name is automatically marked by the time stamp
            File image_file = new File(file, System.currentTimeMillis() + ".jpg");
            try {
                // use an output stream to write data
                OutputStream stream = null;
                // an output stream that writes bytes to a file
                stream = new FileOutputStream(image_file);
                // write a compressed version of the bitmap to the specified output stream
                bitmap.compress(Bitmap.CompressFormat.JPEG,100,stream);
                stream.flush();
                stream.close();
                Toast.makeText(getApplicationContext(), "IMAGE SAVED SUCCESSFULLY", Toast.LENGTH_SHORT).show();

            } catch (Exception e) {
                e.printStackTrace();
            }
            ///////////////////////////////////////////////////////////////////
        }
    }

    // load images
    public void load_images(View view) {
        Intent intent = new Intent(getApplicationContext(),ImageListActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.imageView);
    }
}