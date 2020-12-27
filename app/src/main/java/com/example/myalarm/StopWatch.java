package com.example.myalarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

public class StopWatch extends AppCompatActivity {

    //        variable initialization
   private Chronometer chronometer;
    private long pauseOffset;
    private boolean running;
    Button button18,button19,button20;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);

//        Set Id
         chronometer = findViewById(R.id.Chronometer);
         chronometer.setFormat("%s");
         chronometer.setBase(SystemClock.elapsedRealtime());
         button18 = findViewById(R.id.button18);
         button19 = findViewById(R.id.button19);
         button20 = findViewById(R.id.button20);

//         Page Button set

//        Alarm Button

        button20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoAlarm();
            }

            private void GoAlarm() {
                Intent intent = new Intent(StopWatch.this,MainActivity.class);
                startActivity(intent);
            }
        });

//        Timer Button

        button19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoTimer();
            }

            private void GoTimer() {
                Intent intent = new Intent(StopWatch.this,Timer.class);
                startActivity(intent);
            }
        });

//        Clock Button

        button18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoClock();
            }

            private void GoClock() {
                Intent intent = new Intent(StopWatch.this,Clock.class);
                startActivity(intent);
            }
        });

        //Chronometer Set
         chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
             @Override
             public void onChronometerTick(Chronometer chronometer) {
                 if ((SystemClock.elapsedRealtime() - chronometer.getBase()) >= 10000) {
                     chronometer.setBase(SystemClock.elapsedRealtime());
                     Toast.makeText(StopWatch.this, "Go On!", Toast.LENGTH_LONG).show();
                 }
             }
         });
    }
// Start Button
    public void StartCromo(View v){
        if (!running) {
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
            chronometer.start();
            running = true;
        }
    }

//    pause Button
    public void pauseCromo(View v){
        if (running) {
            chronometer.stop();
            pauseOffset =  SystemClock.elapsedRealtime() - chronometer.getBase();
            running = false;
        }
    }

//    Restart button
    public void RestartCrono(View v){
       chronometer.setBase(SystemClock.elapsedRealtime());
       pauseOffset = 0;
    }
}