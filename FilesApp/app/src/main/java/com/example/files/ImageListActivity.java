package com.example.files;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContextWrapper;
import android.os.Bundle;
import android.widget.Toast;

import java.io.File;

public class ImageListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_list);

        ContextWrapper wrapper = new ContextWrapper(getApplicationContext());
        // directory where the images are stored
        // first parameter is the name of the directory
        // second parameter is the operating mode
        File file = wrapper.getDir("IMAGES",MODE_PRIVATE);
        // get a list of all the images stored in the directory
        File[] files = file.listFiles();
        // setup the recycler view
        setup_image_list(files);
    }

    // function to setup the image list
    public void setup_image_list(File[] files) {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ImageListAdapter imageListAdapter = new ImageListAdapter(this, files);
        recyclerView.setAdapter(imageListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}