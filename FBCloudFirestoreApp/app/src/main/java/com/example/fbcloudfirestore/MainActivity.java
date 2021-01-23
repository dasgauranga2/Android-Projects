package com.example.fbcloudfirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

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
        // Go to 'Cloud Firestore' and select 'Create Database'
        // Select test mode and click 'Enable'
        // Go to Android Studio and go to Tools->Firebase
        // Select 'Cloud Firestore' and click the link
        // Select 'Add the Cloud Firestore SDK' and accept changes

        // ADD DATA TO THE DATABASE
        //FirebaseFirestore db = FirebaseFirestore.getInstance();
        // We use a hash map to add key-value pairs
        //Map<String,Object> city = new HashMap<>();
        //city.put("Name","Noida");
        //city.put("State","UP");
        //city.put("Country","India");
        // The database can contain multiple collections
        // Each collection can contain multiple documents
        // Each document will contain multiple key-value pairs from the hash map
        // We select the collection and document and then add the hash map
//        db.collection("cities").document("DL").set(city).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                // check if task is successful
//                if (task.isSuccessful())  {
//                    Toast.makeText(MainActivity.this, "DATA ADDED SUCCESSFULLY", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Toast.makeText(MainActivity.this, "DATA ADDED FAILED", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

        // RETRIEVE DATA FROM THE DATABASE
        // Select the collection and then select the document
        DocumentReference docref = FirebaseFirestore.getInstance().collection("cities").document("DL");
        docref.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                // check if data retrieval is successful
                if (task.isSuccessful()) {
                    // get the data
                    DocumentSnapshot data = task.getResult();

                    if (data.exists()) {
                        //Toast.makeText(MainActivity.this,data.getData().toString(),Toast.LENGTH_SHORT).show();
                        // convert the data into a hash map type
                        Log.i("FIREBASE_DATA", data.getData().toString());
                    }
                }
            }
        });
    }
}