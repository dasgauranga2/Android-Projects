package com.gauranga.speechrecognition;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView text;
    SpeechRecognizer speechRecognizer;
    Intent intentRecognizer;

    public void record_speech(View view) {
        // start the speech recognition
        speechRecognizer.startListening(intentRecognizer);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView);

        // add permissions in the manifest file
        // check for permissions from the user
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, PackageManager.PERMISSION_GRANTED);
        }

        // create the speech recognizer object
        speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        // create an intent to recognize the speech
        intentRecognizer = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intentRecognizer.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intentRecognizer.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        // set a speech recognition listener
        speechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {

            }
            // function is called when the user starts speaking
            @Override
            public void onBeginningOfSpeech() {
                text.setText("Listening");
            }

            @Override
            public void onRmsChanged(float rmsdB) {

            }

            @Override
            public void onBufferReceived(byte[] buffer) {

            }
            // function is called when the user stops speaking
            @Override
            public void onEndOfSpeech() {

            }

            @Override
            public void onError(int error) {

            }
            // function is called when speech recognition results are ready
            @Override
            public void onResults(Bundle results) {
//                // get the recognized speech
//                ArrayList<String> words = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
//                text.setText(words.get(0));
            }
            // function is called when partial speech recognition results are ready
            @Override
            public void onPartialResults(Bundle partialResults) {
                // get the recognized speech
                ArrayList<String> words = partialResults.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                text.setText(words.get(0));
            }

            @Override
            public void onEvent(int eventType, Bundle params) {

            }
        });
    }
}