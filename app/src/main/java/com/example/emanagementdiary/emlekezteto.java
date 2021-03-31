package com.example.emanagementdiary;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class emlekezteto extends AppCompatActivity {
    EditText datum_mezo, ido_mezo, nev, tartalom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emlekezteto);

        datum_mezo = findViewById(R.id.datumTV);
        ido_mezo = findViewById(R.id.idoTV);
        nev=findViewById(R.id.emlekezeto_nev);
        tartalom=findViewById(R.id.leiras);




    }


}