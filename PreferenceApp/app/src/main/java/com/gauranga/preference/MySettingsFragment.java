package com.gauranga.preference;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.preference.EditTextPreference;
import androidx.preference.Preference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceScreen;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MySettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);

        // in the above xml file add the preferences
        // to access a preference we use the 'key' of the preference
        EditTextPreference signaturePreference = findPreference("signature");
        // set the summary of the above preference
        signaturePreference.setSummaryProvider(new Preference.SummaryProvider<EditTextPreference>() {
            @Override
            public CharSequence provideSummary(EditTextPreference preference) {
                // get the text of the edit text preference
                String text = preference.getText();
                return text;
            }
        });
        // we can also set on click and on preference change listeners
        // for the above preference

        // we can also add preferences programmatically
//        Context context = getPreferenceManager().getContext();
//        PreferenceScreen screen = getPreferenceManager().createPreferenceScreen(context);
//        // create the preference object
//        Preference feedbackPreference = new Preference(context);
//        feedbackPreference.setKey("feedback");
//        feedbackPreference.setTitle("Send feedback");
//        feedbackPreference.setSummary("Report technical issues or suggest new features");
//        // add the preference to the screen
//        screen.addPreference(feedbackPreference);
//        setPreferenceScreen(screen);
    }
}