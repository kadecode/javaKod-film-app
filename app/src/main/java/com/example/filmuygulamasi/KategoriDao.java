package com.example.filmuygulamasi;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class KategoriDao {
    public ArrayList<Kategoriler>tumKategoriler(VeriTabani vt){
        ArrayList<Kategoriler> kategorilerArrayList=new ArrayList<>();
        SQLiteDatabase db1 = vt.getWritableDatabase();
        Cursor c = db1.rawQuery("SELECT * FROM kategoriler",null);

        while (c.moveToNext()){
            Kategoriler k = new Kategoriler(c.getInt(c.getColumnIndex("kategori_id"))
                    ,c.getString(c.getColumnIndex("kategori_ad")));
            kategorilerArrayList.add(k);
        }
        return  kategorilerArrayList;
    }
}
