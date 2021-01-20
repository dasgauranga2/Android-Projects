package com.example.advancedsqlitedatabase;

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
            SQLiteDatabase database = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);

            database.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR, age INT(3))");

//            database.execSQL("INSERT INTO users (name,age) VALUES ('Levi',32)");
//            database.execSQL("INSERT INTO users (name,age) VALUES ('Jean',22)");

            // cursor is used to retrieve data from the table
            // below SQL query selects only those rows from the table where age is greater than 20
            //Cursor c = database.rawQuery("SELECT * FROM users WHERE age > 20", null);
            // below SQL query selects only those rows from the table where the name is Levi
            Cursor c = database.rawQuery("SELECT * FROM users WHERE name = 'Levi'", null);

            int name_index = c.getColumnIndex("name");
            int age_index = c.getColumnIndex("age");

            c.moveToFirst();
            while (c != null) {
                Log.i("USER_DETAILS", c.getString(name_index) + " " + c.getString(age_index));
                c.moveToNext();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}