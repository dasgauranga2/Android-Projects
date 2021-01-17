package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // select the list view
        ListView listView = findViewById(R.id.listView);

        // create an array list which will contain the list view items
        ArrayList<String> names = new ArrayList<String>();
        names.add("Eren");
        names.add("Levi");
        names.add("Armin");
        names.add("Mikasa");
        names.add("Hange");

        // create an array adapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
        // link the list view to the array adapter
        listView.setAdapter(arrayAdapter);

        // detect list view click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            // function is called when a list view item is clicked
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // the list view items have the same ordering as the ArrayList above
                // 'position' is the index of the list view item clicked
                Toast.makeText(getApplicationContext(), "NAME : " + names.get(position),Toast.LENGTH_SHORT).show();
            }
        });
    }
}