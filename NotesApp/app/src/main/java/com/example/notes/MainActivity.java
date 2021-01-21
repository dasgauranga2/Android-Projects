package com.example.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ListViewAutoScrollHelper;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;
    ListView listView;
    ArrayList<String> note_titles;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()) {
            case R.id.new_note:
                //Toast.makeText(getApplicationContext(),"HELP",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, CreateActivity.class);
                startActivity(intent);
                return true;
            default:
                return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        database = this.openOrCreateDatabase("NOTES", MODE_PRIVATE, null);
        listView = findViewById(R.id.listView);
        listView.setLongClickable(true);

        // setup the list of note titles
        setup_note_titles();

        // detect long click on the list view
        // launch an alert dialog box to delete the note
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                new AlertDialog.Builder(MainActivity.this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Are you sure ?")
                    .setMessage("Select the option")
                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        // function is called when the positive button is selected
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            database.execSQL("DELETE FROM notes WHERE title='"+note_titles.get(position)+"'");
                            setup_note_titles();
                        }
                    })
                    .setNegativeButton("No", null).show();

                return true;
            }
        });
    }

    public void setup_note_titles() {

        note_titles = new ArrayList<String>();

        try {
            Cursor c = database.rawQuery("SELECT * FROM notes", null);

            int title_index = c.getColumnIndex("title");

            c.moveToFirst();
            while (c != null) {
                note_titles.add(c.getString(title_index));
                c.moveToNext();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,note_titles);
        listView.setAdapter(arrayAdapter);
    }
}