package com.example.video;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // select the video view
        VideoView videoView = findViewById(R.id.videoView);
        // media controller for controlling the video(play/pause/skip/reverse)
        MediaController mediaController = new MediaController(this);

        // select the video to be played by setting the path of the video
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.ps5);
        // link the media controller and the video view
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        // start playing the video
        videoView.start();
    }
}