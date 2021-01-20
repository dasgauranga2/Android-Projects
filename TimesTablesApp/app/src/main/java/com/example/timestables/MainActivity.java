package com.example.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Spinner spinner;

    public void setup_list(int k) {

        ArrayList<String> names = new ArrayList<String>();

        for (int i=1; i<=10; i++) {
            names.add(k + " X " + i + " = " + i*k);
        }

        // create an array adapter
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,names);
        // link the list view to the array adapter
        listView.setAdapter(arrayAdapter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        // select the spinner for creating a dropdown menu
        spinner = findViewById(R.id.spinner);
        // create an array list which will contain the dropdown menu items
        ArrayList<Integer> nums = new ArrayList<Integer>();
        for (int j=1; j<=10; j++) {
            nums.add(j);
        }
        // create an adapter for the spinner
        ArrayAdapter<Integer> spinner_adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item,nums);
        spinner_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // link the spinner and the adapter
        spinner.setAdapter(spinner_adapter);
        // detect whenever any dropdown menu item is selected
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), String.valueOf(position),Toast.LENGTH_SHORT).show();
                setup_list(position+1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}