package com.example.filmuygulamasi;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KategoriAdapter extends RecyclerView.Adapter<KategoriAdapter.CardTasarimiTutucu> {
    private Context mContext;
    private List<Kategoriler> kategorilerList;

    public KategoriAdapter(Context mContext, List<Kategoriler> kategorilerList) {
        this.mContext = mContext;
        this.kategorilerList = kategorilerList;
    }

    @NonNull
    @Override
    public CardTasarimiTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kategori_karttasarim,parent,false);

        return new CardTasarimiTutucu(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimiTutucu holder, int position) {
       Kategoriler kategoriler = kategorilerList.get(position);

       holder.textViewAd.setText(kategoriler.getKategori_ad());

       holder.kategori_card.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(mContext,FilmlerActivity.class);
               intent.putExtra("kategori_nesne",kategoriler);
               mContext.startActivity(intent);

           }
       });
    }

    @Override
    public int getItemCount() {
        return kategorilerList.size();
    }

    public class CardTasarimiTutucu extends RecyclerView.ViewHolder{
        private CardView kategori_card;
        private TextView textViewAd;

        public CardTasarimiTutucu(@NonNull View itemView) {
            super(itemView);
            kategori_card = itemView.findViewById(R.id.kategori_card);
            textViewAd = itemView.findViewById(R.id.textViewAd);
        }
    }

}
