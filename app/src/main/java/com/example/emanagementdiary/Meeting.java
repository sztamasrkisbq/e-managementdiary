package com.example.emanagementdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Meeting extends AppCompatActivity {

    EditText mail_cimzett, email_uzenet,meeting_neve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting);

        Button sendbut = findViewById(R.id.btn_createMeeting);

        mail_cimzett = findViewById(R.id.et_emailCimzett);
        email_uzenet = findViewById(R.id.et_mailIUzenet);
        meeting_neve = findViewById(R.id.et_meetingTargy);

        sendbut.setOnClickListener(v -> send_messages());
    }


    //SMS KÜLDÉS
    private void send_messages() {

        // itt lehet tobb emailt felsorolni
        String mailList = mail_cimzett.getText().toString();
        String[] mailS = mailList.split(",");

        // letrehozzuk a targyat, uzenetet
        String subject = meeting_neve.getText().toString();
        String mess = email_uzenet.getText().toString();


        // bepakoljük az összetevőket

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, mailS);
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, mess);

        intent.setType("message/rfc822");

        startActivity(Intent.createChooser(intent, "Valassz email klienst!")); // ki lehet valasztani min keresztül küldjük az emailt

    }





}