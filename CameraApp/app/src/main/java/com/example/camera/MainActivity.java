package com.example.camera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    File output_image;
    String currentPhotoPath;
    Uri image_uri;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    // click button to take pictures
    public void take_pic(View view) throws IOException {
        // create an intent to launch the camera app
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // create a file where the image will be stored
        File image_file = createImageFile();
        // create an image uri using the file
        // the second argument must match the package name of the app
        image_uri = FileProvider.getUriForFile(this, "com.example.camera", image_file);
        // after capturing the image put the result in this image uri
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, image_uri);
        // start the intent
        startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

        // IMPORTANT
        // In the manifest file 'AndroidManifest.xml' file
        // we have to add a file provider
        // The file provider has an 'authorities' attribute
        // which must match the package name of the app
        // Create a file 'file_paths.xml' in the res/xml/ directory
        // and specify the paths
    }

    // function is invoked after
    // image is captured
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // check if image is successfully captured
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bitmap bitmap = null;
            try {
                // create a bitmap from the image uri
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), image_uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            // set the image view using bitmap
            image.setImageBitmap(rotateImage(bitmap,90));
        }
    }

    // function to rotate the image bitmap
    public static Bitmap rotateImage(Bitmap source, float angle) {
        Matrix matrix = new Matrix();
        matrix.postRotate(angle);
        return Bitmap.createBitmap(source, 0, 0, source.getWidth(), source.getHeight(),
                matrix, true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.imageView);
    }

    // this function will create a file
    // the file name will be marked by the timestamp
    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }
}