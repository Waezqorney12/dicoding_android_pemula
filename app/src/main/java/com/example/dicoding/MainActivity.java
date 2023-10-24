package com.example.dicoding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements selectedItem {

    private RecyclerView recyclerView;
    private ArrayList<Pemain> list = new ArrayList<>();
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.listID);
        recyclerView.setHasFixedSize(true);

        imageView = findViewById(R.id.photoprof);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutProfile.class);
                intent.putExtra("nama_profile", "Waezqorney Huanfareyzo");
                intent.putExtra("email_profile", "waezqorney12@gmail.com");
                intent.putExtra("asal_profile", "Dicoding Indonesia Tahun 2023");
                startActivity(intent);
            }
        });
        getSupportActionBar().hide();
        list.addAll(getListPemain());
        showRecyclerList();
    }


    // Ini digunakan untuk menentukan index dari list yang kegunaannya ketika di klik akan sesuai dengan index yang di klik
    // dan kemudian akan disimpan kedalam List Pemain yang sudah dibuat model nya tadi
    public ArrayList<Pemain> getListPemain() {
        String[] dataName = getResources().getStringArray(R.array.list_pemain);
        String[] dataDescription = getResources().getStringArray(R.array.deskripsi_pemain);
        TypedArray dataPhoto = getResources().obtainTypedArray(R.array.photo_pemain);
        ArrayList<Pemain> listHero = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Pemain pemain = new Pemain();
            pemain.set_nama(dataName[i]);
            pemain.set_deskripsi(dataDescription[i]);
            pemain.set_photo(dataPhoto.getResourceId(i, -1));
            listHero.add(pemain);
        }
        return listHero;
    }

    private void showRecyclerList() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PemainAdapter listHeroAdapter = new PemainAdapter(list, this, this);
        recyclerView.setAdapter(listHeroAdapter);
    }

    @Override
    public void selectedItemClick(Pemain pemain) {
        Intent detailIntent = new Intent(MainActivity.this, detailScreen.class);
        detailIntent.putExtra("nama_item", pemain.get_nama());
        detailIntent.putExtra("deskripsi_item", pemain.get_deskripsi());
        detailIntent.putExtra("photo_item", pemain.get_photo());
        startActivity(detailIntent);
    }
}
