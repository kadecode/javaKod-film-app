package com.example.filmuygulamasi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar tolbar;
    private RecyclerView kategoriRv;
    private ArrayList<Kategoriler> kategorilerArrayList;
    private KategoriAdapter adapter;
    private VeriTabani vt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tolbar = findViewById(R.id.toolbar);
        kategoriRv = findViewById(R.id.kategoriRv);
        veritabaniKopyala();
        vt = new VeriTabani(this);

        tolbar.setTitle("Kategoriler");
        setSupportActionBar(tolbar);
        kategoriRv.setHasFixedSize(true);
        kategoriRv.setLayoutManager(new LinearLayoutManager(this));

        kategorilerArrayList = new KategoriDao().tumKategoriler(vt);

        adapter = new KategoriAdapter(this,kategorilerArrayList);
        kategoriRv.setAdapter(adapter);

    }
    public void veritabaniKopyala(){
       DatabaseCopyHelper helper = new DatabaseCopyHelper(this);
        try {
            helper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }
        helper.openDataBase();
    }
}