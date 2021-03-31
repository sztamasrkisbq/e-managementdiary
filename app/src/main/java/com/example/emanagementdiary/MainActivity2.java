package com.example.emanagementdiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        backtoactivity1();
        GoToMeetingActivity();
        GoToEmlekeztetoActivity();
    }


    private void backtoactivity1() {
        Button nextButton = (Button) findViewById(R.id.vissza);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
            }
        });
    }

    private void GoToMeetingActivity() {
        Button nextButton = (Button) findViewById(R.id.btn_meeting);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, CreateMeetingActivity.class));
            }
        });
    }


    private void GoToEmlekeztetoActivity() {
        Button nextButton = (Button) findViewById(R.id.btn_emlekezteto);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity2.this, emlekezteto.class));
            }
        });
    }

}