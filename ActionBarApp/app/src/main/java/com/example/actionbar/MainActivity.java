package com.example.actionbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // function to setup the menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        // link the menu to the 'main_menu.xml' file
        menuInflater.inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    // function to detect if a menu item is selected
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        // we detect which menu item was selected
        // by matching the id of the menu item
        // item.getItemId() returns the id of the menu item
        switch (item.getItemId()) {
            case R.id.settings:
                Toast.makeText(getApplicationContext(),"SETTINGS",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.help:
                Toast.makeText(getApplicationContext(),"HELP",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Right-click 'res' folder and go to New->Directory
        // Create a folder named 'menu'
        // Right-click 'menu' folder and go to New->Menu Resource File
        // Create a file named 'main_menu'
        // Go to res/menu/main_menu.xml file and create the menu items
    }
}