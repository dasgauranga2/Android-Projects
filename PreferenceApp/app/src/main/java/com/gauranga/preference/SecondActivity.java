package com.gauranga.preference;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.EditTextPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // 1. add the gradle dependencies for the androidx preference library
        // 2. create a layout where the settings will be displayed
        // 3. create a new fragment to setup the settings
        // 4. use fragment transaction to put the fragment object in the layout
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.settings_container, new MySettingsFragment())
                .commit();
    }

    // display all the preference settings values
    public void check(View view) {
        // use shared preference to retrieve the values
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        // first parameter is the key of the preference we want to retrieve
        // second parameter is the default value
        boolean not = sharedPreferences.getBoolean("notifications", false);
        String sig = sharedPreferences.getString("signature", "DEFAULT VALUE");
        // display the values
        Log.i("PREFERENCE_VALUE", not + " ");
        Log.i("PREFERENCE_VALUE", sig);
    }
}