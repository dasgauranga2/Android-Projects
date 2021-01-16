package com.example.textfield;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void popup(View view) {
        // select the edit text view
        EditText name = (EditText) findViewById(R.id.nameText);
        // get the text from the edit text view
        String text = name.getText().toString();

        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}