package com.example.emanagementdiary;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GoToActivity2();
        GoToMeetingek();
        GoToEmlekeztetok();
    }

    private void GoToActivity2() {
        FloatingActionButton nextButton = (FloatingActionButton) findViewById(R.id.btn_ujesemeny);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity2.class));
            }
        });
    }

    private void GoToMeetingek() {
        Button nextButton = (Button) findViewById(R.id.btn_meetingek);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Meetingek.class));
            }
        });
    }


    private void GoToEmlekeztetok() {
        Button nextButton = (Button) findViewById(R.id.btn_emlekeztetok);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Emlekeztetok.class));
            }
        });
    }
}