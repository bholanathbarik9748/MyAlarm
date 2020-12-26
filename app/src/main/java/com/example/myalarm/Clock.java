package com.example.myalarm;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Clock extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);

//        variable initialization

        Button  Button8 =(Button) findViewById(R.id.button8);
        Button  Button9 =(Button) findViewById(R.id.button9);
        Button  Button7 =(Button) findViewById(R.id.button7);

//        Set Stop-Watch Button

        Button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoStopWatch();
            }

            private void GoStopWatch() {
                Intent intent = new Intent(Clock.this,StopWatch.class);
                startActivity(intent);
            }
        });

//        Set Alarm Button

        Button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoClock();
            }
            private void GoClock(){
                Intent intent = new Intent(Clock.this,MainActivity.class);
                startActivity(intent);
            }
        });

//        Set Timer Button

        Button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoTimer();
            }

            private void GoTimer() {
                Intent intent = new Intent(Clock.this,Timer.class);
                startActivity(intent);
            }
        });

    }
}