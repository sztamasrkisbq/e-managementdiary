package com.example.emanagementdiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EMAIL extends AppCompatActivity {
    EditText email_cimek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emails);

        email_cimek = findViewById(R.id.text_email);
    }


}