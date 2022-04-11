package com.example.filmuygulamasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class DetayActivity extends AppCompatActivity {
    private TextView textViewFilmYili,textViewYonetmen,textViewFilmAdi;
    private ImageView imageViewResim;
    private Filmler film;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detay);

        imageViewResim = findViewById(R.id.imageViewResim);
        textViewFilmAdi = findViewById(R.id.textViewFilmAdi);
        textViewFilmYili = findViewById(R.id.textViewFilmYili);
        textViewYonetmen = findViewById(R.id.textViewYonetmen);
        film = (Filmler) getIntent().getSerializableExtra("nesne");

        textViewFilmAdi.setText(film.getFilm_ad());
        textViewFilmYili.setText(String.valueOf(film.getFilm_yil()));
        textViewYonetmen.setText(film.getYonetmen().getYonetmen_ad());

        //imageViewResim.setImageResource(getResources().getIdentifier(film.getFilm_resim()
        // ,"drawable",getPackageName()));
        imageViewResim.setImageResource(getResources().getIdentifier(film.getFilm_resim()
                ,"drawable",getPackageName()));

    }
}