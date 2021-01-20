package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            // creates a new database or open an existing database
            // the first argument is the name of the database
            SQLiteDatabase database = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);

            // create a table called 'users' if one already does not exists
            // we specify the fields of the table and their types
            database.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");

            // insert data into the table
            database.execSQL("INSERT INTO users (name,age) VALUES ('Levi',32)");
            database.execSQL("INSERT INTO users (name,age) VALUES ('Jean',22)");

            // cursor is used to retrieve data from the table
            // below SQL query selects all the rows from the table
            Cursor c = database.rawQuery("SELECT * FROM users", null);
            // 'name' column index
            int name_index = c.getColumnIndex("name");
            // 'age' column index
            int age_index = c.getColumnIndex("age");

            // move the cursor to the beginning
            c.moveToFirst();
            while (c != null) {
                // retrieve data from the table using the cursor and column index
                Log.i("NAME", c.getString(name_index));
                Log.i("AGE", c.getString(age_index));
                // move the cursor to the next data point
                c.moveToNext();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}