package com.example.emanagementdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Meeting extends AppCompatActivity {

    EditText mail_cimzett, email_uzenet,meeting_neve, sms_msg, sms_cimzett;
    private static final int RESULT_PICK_CONTACT =1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting);


        Button sendemail = findViewById(R.id.btn_createMeeting);
        Button sendsms = findViewById(R.id.btn_createMeeting2);
        Button telefonszamok = findViewById(R.id.btn_addContact);

        mail_cimzett = findViewById(R.id.et_emailCimzett);
        email_uzenet = findViewById(R.id.et_mailIUzenet);
        meeting_neve = findViewById(R.id.et_meetingTargy);
        sms_cimzett = findViewById(R.id.et_smsCimzett);
        sms_msg = findViewById(R.id.et_smsUzenet);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            if (checkSelfPermission(Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED)
            {
                sendsms.setOnClickListener(v -> smsSend());
            }
            else
                {
                    requestPermissions(new String[] {Manifest.permission.SEND_SMS}, 1);
                }
        }

        telefonszamok.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent in = new Intent (Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI);
                startActivityForResult (in, RESULT_PICK_CONTACT);
            }
        });



        sendemail.setOnClickListener(v -> send_messages());
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case RESULT_PICK_CONTACT:
                    contactPicked(data);
                    break;
            }
        } else {
            Toast.makeText(this, "Failed To pick contact", Toast.LENGTH_SHORT).show();
        }
    }

    private void smsSend()
    {
        String phoneNum = sms_cimzett.getText().toString().trim();
        String sms = sms_msg.getText().toString().trim();
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNum,null,sms,null,null);
            Toast.makeText(this,"SMS elküldve!",Toast.LENGTH_SHORT).show();
        }catch (Exception e)
        {
            e.printStackTrace();
            Toast.makeText(this,"SMS küldés sikertelen",Toast.LENGTH_SHORT).show();
        }
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



    private void contactPicked(Intent data) {
        Cursor cursor = null;

        try {
            String phoneNo = null;
            String nev = null;
            Uri uri = data.getData ();
            cursor = getContentResolver ().query (uri, null, null,null,null);
            cursor.moveToFirst ();
            int phoneIndex = cursor.getColumnIndex (ContactsContract.CommonDataKinds.Phone.NUMBER);   // teloszam
            int name = cursor.getColumnIndex (ContactsContract.CommonDataKinds.Nickname.DISPLAY_NAME); // neve

            phoneNo = cursor.getString (phoneIndex);
            nev = cursor.getString (name);

            sms_cimzett.setText (phoneNo);



        } catch (Exception e) {
            e.printStackTrace ();
        }
    }




}