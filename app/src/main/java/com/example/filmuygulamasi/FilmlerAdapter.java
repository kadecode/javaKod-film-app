package com.example.filmuygulamasi;

import android.content.Context;
import android.content.Intent;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class FilmlerAdapter extends RecyclerView.Adapter<FilmlerAdapter.FilmCardTutucu> {
    private Context mContext;
    private List<Filmler> filmlerList;

    public FilmlerAdapter(Context mContext, List<Filmler> filmlerList) {
        this.mContext = mContext;
        this.filmlerList = filmlerList;
    }

    @NonNull
    @Override
    public FilmCardTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.film_card_tadarim,parent,false);
        return new FilmCardTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmCardTutucu holder, int position) {
       final Filmler film = filmlerList.get(position);

        holder.textViewFilmAd.setText(film.getFilm_ad());
        holder.imageViewFilmResimler.setImageResource(mContext.getResources().getIdentifier(film.getFilm_resim()
                ,"drawable",mContext.getPackageName()));

        holder.film_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,DetayActivity.class);
                intent.putExtra("nesne",film);
                 mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return filmlerList.size();
    }

    public class FilmCardTutucu extends RecyclerView.ViewHolder{
        private  CardView film_card;
        private ImageView imageViewFilmResimler;
        private TextView textViewFilmAd;

        public FilmCardTutucu(@NonNull View itemView) {
            super(itemView);
            film_card = itemView.findViewById(R.id.film_card);
            imageViewFilmResimler = itemView.findViewById(R.id.imageViewFilmResim);
            textViewFilmAd = itemView.findViewById(R.id.textViewFilmAd);

        }
    }

}
