package com.example.fbrealtimedatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Go to Tools->Firebase
        // Go to Analytics and click the link
        // Select to 'Connect to Firebase'
        // Select a project
        // Go Firebase website and then go to console
        // Select the project
        // Go to 'Realtime Database' and select 'Create Database'
        // Select test mode and click 'Enable'
        // Go to Android Studio and go to Tools->Firebase
        // Select 'Realtime Database' and click the link
        // Select 'Add the Realtime Database SDK' and accept changes

        // ADD DATA TO THE DATABASE
        // We add data in a tree like format
        // The root can have multiple branches
        // Each branch can have other branches
        // '.child()' creates a branch
        // '.setValue()' sets a value for the branch
        //FirebaseDatabase.getInstance().getReference().child("PROGRAMMING").child("Android").setValue("abcd");

        // ADD MULTIPLE VALUES TO THE DATABASE
        // We use a hash map
        //HashMap<String,Object> map = new HashMap<>();
        //map.put("Name","Gauranga Das");
        //map.put("Age","21");
        //map.put("Location","India");
        //FirebaseDatabase.getInstance().getReference().child("Personal Info").updateChildren(map);

        // RETRIEVE DATA FROM THE DATABASE
        // Select the branch which contains multiple branches
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Personal Info");
        // add an event listener to read data
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // we iterate through all child branches of the above selected branch
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    // key is the name of the branch
                    String key = dataSnapshot.getKey();
                    // value is the data in that branch
                    String value = dataSnapshot.getValue().toString();
                    Toast.makeText(MainActivity.this, key + " : " + value, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}