package com.example.audio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    public void play(View view) {
        // play the audio
        mediaPlayer.start();
    }

    public void pause(View view) {
        // play the audio
        mediaPlayer.pause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create the media player and set the audio file path
        mediaPlayer = MediaPlayer.create(this,R.raw.grenade);
    }
}