package com.gauranga.touchevents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    TextView text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textView);
        text2 = findViewById(R.id.textView2);
    }

    // method is called when the touch screen is touched, released or dragged
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // get the touch event
        int action = event.getAction();

        // FIND THE EVENT TYPE
//        switch (action) {
//            case (MotionEvent.ACTION_DOWN):
//                // touch screen is pressed
//                text.setText("Touch screen pressed");
//                return  true;
//            case (MotionEvent.ACTION_MOVE):
//                // contact has moved across the touch screen
//                text.setText("Contact with touch screen has moved");
//                return  true;
//            case (MotionEvent.ACTION_UP):
//                // touch screen contact has ended
//                text.setText("Touch screen contact has ended");
//                return  true;
//            case (MotionEvent.ACTION_CANCEL):
//                // touch event has cancelled
//                return  true;
//            case (MotionEvent.ACTION_OUTSIDE):
//                //
//                return  true;
//            default:
//                return super.onTouchEvent(event);
//        }

        // CHECK FOR MULTIPLE TOUCHSCREEN CONTACTS
        // get the number of touch screen contacts
        if (event.getPointerCount() > 1) {
            // get the x and y coordinates of the first touch screen contact
            int x_pos = (int)event.getX(0);
            int y_pos = (int)event.getY(0);
            text.setText("(" + x_pos + "," + y_pos + ")");

            // get the x and y coordinates of the second touch screen contact
            int x_pos2 = (int)event.getX(1);
            int y_pos2 = (int)event.getY(1);
            text2.setText("(" + x_pos2 + "," + y_pos2 + ")");
        }
        else {
            // SINGLE TOUCH CONTACT

            // get the x coordinate of the current touch screen contact
            int x_pos = (int)event.getX();
            // get the y coordinate of the current touch screen contact
            int y_pos = (int)event.getY();

            text.setText("(" + x_pos + "," + y_pos + ")");
        }
        return super.onTouchEvent(event);
    }
}