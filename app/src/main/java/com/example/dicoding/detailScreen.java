package com.example.dicoding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class detailScreen extends AppCompatActivity {
    ImageView imagePemain;
    TextView namaPemain, deskripsiPemain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screen);

        imagePemain = findViewById(R.id.imagePemain);
        namaPemain = findViewById(R.id.namePemain);
        deskripsiPemain = findViewById(R.id.descriptionPemain);

        Intent intent = getIntent();

        String nama = intent.getStringExtra("nama_item");
        String deskripsi = intent.getStringExtra("deskripsi_item");
        int photoResId = intent.getIntExtra("photo_item", 0);

        namaPemain.setText(nama);
        deskripsiPemain.setText(deskripsi);
        imagePemain.setImageResource(photoResId);
    }
}
