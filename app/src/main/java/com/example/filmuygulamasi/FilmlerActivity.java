package com.example.filmuygulamasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

import java.util.ArrayList;

public class FilmlerActivity extends AppCompatActivity {
    private Toolbar toolbar2;
    private RecyclerView filmRv;
    private ArrayList<Filmler> filmlerArrayList;
    private FilmlerAdapter filmlerAdapter;
    private Kategoriler kategori;
    private VeriTabani vt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmler);
        toolbar2 = findViewById(R.id.toolbar2);
        filmRv = findViewById(R.id.filmRv);

        try (VeriTabani vt = new VeriTabani(this)) {

            kategori = (Kategoriler) getIntent().getSerializableExtra("kategori_nesne");

            toolbar2.setTitle(kategori.getKategori_ad());
            setSupportActionBar(toolbar2);

            filmlerArrayList = new FilmlerDao().tumFilmlerByKategoriId(vt,kategori.getKategori_id());
        }

        filmRv.setHasFixedSize(true);
        filmRv.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        filmlerAdapter = new FilmlerAdapter(this,filmlerArrayList);
        filmRv.setAdapter(filmlerAdapter);

    }
}