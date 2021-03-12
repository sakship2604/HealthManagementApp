package com.example.healthmanagementapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    LinearLayout layoutDoctor,layoutPatient,layoutImg;
    ImageView imgDoc, imgPat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        layoutImg = findViewById(R.id.linearLayout);
        layoutDoctor = findViewById(R.id.linearLayoutDoctor);
        layoutPatient = findViewById(R.id.linearLayoutPatient);

        imgDoc.setImageResource(R.drawable.doctor);
        imgPat.setImageResource(R.drawable.patient);

        layoutDoctor.setVisibility(View.GONE);
        layoutPatient.setVisibility(View.GONE);

        imgDoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutDoctor.setVisibility(View.VISIBLE);
                layoutPatient.setVisibility(View.GONE);
            }
        });
        imgPat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutDoctor.setVisibility(View.GONE);
                layoutPatient.setVisibility(View.VISIBLE);
            }
        });
    }

}