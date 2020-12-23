package com.example.myalarm;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Clock extends AppCompatActivity {
    private Button Button8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock);
        Button8 =(Button) findViewById(R.id.button8);
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
    }
}