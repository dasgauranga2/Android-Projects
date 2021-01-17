package com.example.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // create a countdown timer
        // we execute a block of code repeatedly
        // first argument is the total amount of time to run the code
        // second argument is frequency at which the block of code will be executed
        new CountDownTimer(10000,1000) {
            // function is called every cycle
            @Override
            public void onTick(long millisUntilFinished) {
                // 'millisUntilFinished' is the milliseconds left for the timer to finish
                Log.i("SECONDS LEFT ", String.valueOf(millisUntilFinished/1000));
            }
            // function is called at the end of timer
            @Override
            public void onFinish() {
                Log.i("SECONDS LEFT ", "FINISHED");
            }
        }.start();
    }
}