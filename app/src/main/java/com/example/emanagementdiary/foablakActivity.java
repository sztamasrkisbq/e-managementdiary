package com.example.emanagementdiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.firebase.auth.FirebaseAuth;

public class foablakActivity extends AppCompatActivity {

    GoogleSignInClient mGoogleSignInClient;
    Button sign_outBtn;
    TextView tv_name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foablak);

        sign_outBtn = findViewById(R.id.btn_SignOut);
        tv_name = findViewById(R.id.tv_nev);

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if(signInAccount != null){
            tv_name.setText(signInAccount.getDisplayName());
        }

        sign_outBtn.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();   //firebase sign out
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(intent);
        });
    }
}