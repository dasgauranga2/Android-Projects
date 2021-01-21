package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateActivity extends AppCompatActivity {

    EditText title_input,body_input;
    SQLiteDatabase database;

    // function to save the note
    public void save_note(View view) {

        String title = title_input.getText().toString();
        String body = body_input.getText().toString();

        database.execSQL("CREATE TABLE IF NOT EXISTS notes (title VARCHAR, body VARCHAR)");

        database.execSQL("INSERT INTO notes (title, body) VALUES ('"+title+"','"+body+"')");

        Intent intent = new Intent(CreateActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        title_input = findViewById(R.id.titleInput);
        body_input = findViewById(R.id.bodyInput);

        database = this.openOrCreateDatabase("NOTES", MODE_PRIVATE, null);
    }
}