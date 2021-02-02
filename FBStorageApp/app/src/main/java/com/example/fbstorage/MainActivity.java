package com.example.fbstorage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class MainActivity extends AppCompatActivity {

    Button upload;
    ImageView imageView;
    Uri image_uri;
    String download_url;

    private static final int IMAGE_REQUEST = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Go to Tools->Firebase
        // Go to Analytics and click the link
        // Select to 'Connect to Firebase'
        // Select a project
        // Go Firebase website and then go to console
        // Select the project
        // Go to 'Cloud Storage' and select 'Get started'
        // Create a new bucket
        // Go to Android Studio and go to Tools->Firebase
        // Select 'Cloud Storage' and click the link
        // Select 'Add the Cloud Storage SDK' and accept changes

        upload = findViewById(R.id.uploadButton);
        imageView = findViewById(R.id.imageView);

        // button to upload the image
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                open_image();
            }
        });
    }

    // function to open the image from gallery
    private void open_image() {
        // launch an intent
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
            Toast.makeText(MainActivity.this, "IMAGE RETRIEVAL SUCCESSFUL", Toast.LENGTH_SHORT).show();
            // get the image data in uri format
            image_uri = data.getData();
            // upload the image to Firebase database
            upload_image();
        }
    }

    // function to download the image
    private void download_image() {
        // set the database reference
        // set the directory and file name
        StorageReference storageReference = FirebaseStorage.getInstance().getReferenceFromUrl(download_url);
        // download the image using url
        storageReference.getBytes(1200*1200).addOnSuccessListener(new OnSuccessListener<byte[]>() {
            @Override
            public void onSuccess(byte[] bytes) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
                imageView.setImageBitmap(bitmap);
            }
        });
    }

    // function to upload the image
    private void upload_image() {

        if (image_uri !=  null) {
            // set the database reference
            // set the directory and file name
            StorageReference storageReference = FirebaseStorage.getInstance().getReference().child("uploads").child("test.jpg");
            // upload the uri image
            storageReference.putFile(image_uri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                    storageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            // get the download url for the image
                            String url = uri.toString();
                            // set the download url of the image
                            download_url = url;
                            Toast.makeText(MainActivity.this, "IMAGE UPLOAD SUCCESSFUL", Toast.LENGTH_SHORT).show();
                            // download the image
                            download_image();
                        }
                    });
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, "IMAGE UPLOAD FAILED", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}