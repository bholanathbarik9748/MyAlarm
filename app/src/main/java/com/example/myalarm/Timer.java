package com.example.myalarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class Timer extends AppCompatActivity {
    private static final long START_TIME_IN_MILLIS = 600000;
    //        variable initialization
    TextView textView3;
    Button button12,button5,button6;
    Button button10;
    Button button11;
    CountDownTimer mc;
    boolean mt;
    private  long mtL = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);
        //        ID set
        textView3  = findViewById(R.id.textView3);
        button11 = findViewById(R.id.button11);
        button12 = findViewById(R.id.button12);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button10 = findViewById(R.id.button10);


        //        let's go Next page

         //        Fo to Stop-Watch
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoStopWatch();
            }

            private void GoStopWatch() {
                Intent intent = new Intent(Timer.this,StopWatch.class);
                startActivity(intent);
            }
        });


        //        Go to Alarm
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goClock();
            }

            private void goClock() {
                Intent intent = new Intent(Timer.this,MainActivity.class);
                startActivity(intent);
            }
        });

//        Go to Clock
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goClock();
            }

            private void goClock() {
                Intent intent = new Intent(Timer.this,Clock.class);
                startActivity(intent);
            }
        });



        //        restart
          button12.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  RestartTimer();
              }

              private void RestartTimer() {
                  mtL = START_TIME_IN_MILLIS;
                  updateCountDownText();
                  button12.setText("Restart");
                  button11.setVisibility(View.VISIBLE);
              }

              private void updateCountDownText() {
                  int min = (int) (mtL / 1000) / 60;
                  int sec = (int) (mtL / 1000) % 60;

                  String tlf = String.format(Locale.getDefault(), "%02d:%02d", min, sec);
                  textView3.setText(tlf);
              }
          });
//    Start Button set
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mt){
                    pauseTime();
                }else{
                    StartTimer();
                }
            }

            private void StartTimer() {
                mc = new CountDownTimer(mtL, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        mtL = millisUntilFinished;
                        updateCountDownText();
                    }

                    private void updateCountDownText() {
                        int min = (int) (mtL / 1000) / 60;
                        int sec = (int) (mtL / 1000) % 60;

                        String tlf = String.format(Locale.getDefault(), "%02d:%02d", min, sec);
                        textView3.setText(tlf);
                    }
//   Set final Button
                    @Override
                    public void onFinish() {
                        mt = false;
                        button11.setText("Start");
                        button11.setVisibility(View.VISIBLE);
                        button12.setVisibility(View.VISIBLE);
                    }
                }.start();
                mt = true;
                button11.setText("Pause");
                button12.setVisibility(View.VISIBLE);
            }
            private void pauseTime() {
                mc.cancel();
                mt = false;
                button11.setText("Start");
                button12.setVisibility(View.VISIBLE);
            }
        });
    }
}