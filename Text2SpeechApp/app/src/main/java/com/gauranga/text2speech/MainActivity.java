package com.gauranga.text2speech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText text;
    TextToSpeech tts;

    public void speak(View view) {
        // get the text entered by the user
        String user_text = text.getText().toString();
        // speak the text
        tts.speak(user_text, TextToSpeech.QUEUE_FLUSH, null, null);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.editText);
        // initialize the text-to-speech object
        tts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                // set the language
                tts.setLanguage(Locale.UK);
                // set the speech rate
                tts.setSpeechRate(0.6f);
                // set the pitch
                tts.setPitch(0.6f);
            }
        });
    }
}