package com.example.firebaseml;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.mlkit.vision.common.InputImage;
import com.google.mlkit.vision.text.Text;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    TextView txt;

    private static final int IMAGE_REQUEST = 2;

    // function to send an image to another user
    public void add_image(View view) {

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
            // convert the iage to bitmap format
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), image_uri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            image.setImageBitmap(bitmap);

            // create an InputImage object from the bitmap
            InputImage input_image = InputImage.fromBitmap(bitmap,90);
            // create an instance of TextRecognizer
            TextRecognizer recognizer = TextRecognition.getClient();
            // process the image
            Task<Text> result = recognizer.process(input_image).addOnSuccessListener(new OnSuccessListener<Text>() {
                @Override
                public void onSuccess(Text text) {
                    // get the recognized text
                    String result = text.getText();
                    //Log.i("RECOGNIZED_TEXT", result);
                    txt.setText(result);
                }
            });
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // add the ml-kit text recognizer dependencies to gradle file
        // add meta-data dependencies to manifest file

        image = findViewById(R.id.imageView);
        txt = findViewById(R.id.textView);
        txt.setMovementMethod(new ScrollingMovementMethod());
    }
}