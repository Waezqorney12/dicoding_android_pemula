package com.example.dicoding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class AboutProfile extends AppCompatActivity {

    TextView namaText,emailText,asalText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_profile);
        namaText = findViewById(R.id.namaText);
        emailText = findViewById(R.id.emailText);
        asalText = findViewById(R.id.asalText);

        Intent intent = getIntent();
        namaText.setText(intent.getStringExtra("nama_profile"));
        emailText.setText(intent.getStringExtra("email_profile"));
        asalText.setText(intent.getStringExtra("asal_profile"));
    }
}