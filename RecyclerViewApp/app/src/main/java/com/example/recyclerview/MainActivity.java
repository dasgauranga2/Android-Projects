package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Go the directory where the 'MainActivity.java' file is stored
        // Right-click and go to New->Java Class and then create a new class 'MyAdapter.java' file
        // In that file specify the settings for the recycler view

        // Right-click on the layout folder
        // Go to New->Layout Resource File and create a file called 'row.xml'
        // This file defines the style for each row

        // s1 and s2 are the data that we are going to display in the recycler view
        String[] s1 = {"C++","Java","Python","Javascript"};
        String[] s2 = {"Very fast","Object-oriented","Simple to use","For websites"};
        recyclerView = findViewById(R.id.recyclerView);

        // create a custom adapter for the recycler view
        // pass the context and data as arguments
        MyAdapter myAdapter = new MyAdapter(this,s1,s2);
        // set the custom adapter
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}