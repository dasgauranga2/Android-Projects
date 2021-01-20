package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView time_left;
    int total_time;
    SeekBar seekBar;

    public void reset_timer() {
        time_left.setText(String.valueOf(10));
        // set the current value of seek bar
        seekBar.setProgress(10);
    }

    public void start_timer(View view) {

        seekBar.setVisibility(View.GONE);

        new CountDownTimer(total_time*1000,1000) {
            // function is called every cycle
            @Override
            public void onTick(long millisUntilFinished) {

                time_left.setText(String.valueOf(millisUntilFinished/1000));
            }
            // function is called at the end of timer
            @Override
            public void onFinish() {
                seekBar.setVisibility(View.VISIBLE);
                reset_timer();
            }
        }.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // select the seek bar
        seekBar = findViewById(R.id.seekBar);
        time_left = findViewById(R.id.timeLeftView);

        reset_timer();

        // detect if seek bar is changed
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // progress is the current value of seek bar
                time_left.setText(String.valueOf(progress));
                total_time = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}