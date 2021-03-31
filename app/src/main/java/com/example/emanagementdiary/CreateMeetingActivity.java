package com.example.emanagementdiary;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.Calendar;

public class CreateMeetingActivity extends AppCompatActivity {
    EditText mail_mezo, telszam_mezo, datum_mezo, meeting_neve, sms_uzenet, email_uzenet;

    // sms része
    final int SEN_SMS_PERMISSION_REQU = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meeting);

        meeting_neve = findViewById(R.id.meet_name);
        mail_mezo = findViewById(R.id.mailcimek);    //itt vanak az e-mail címek
        email_uzenet = findViewById(R.id.email_message);
        telszam_mezo = findViewById(R.id.telszamok);
        sms_uzenet = findViewById(R.id.sms_message);
        datum_mezo = findViewById(R.id.datumTV);


    }

}