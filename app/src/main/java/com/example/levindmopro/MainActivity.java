package com.example.levindmopro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.levindmopro.adapter.MantanAdapter;
import com.example.levindmopro.helper.LocaleHelper;
import com.example.levindmopro.model.MantanModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {
    DatabaseHelperEx myDbEx;

    MantanAdapter adapter;
    RecyclerView rv;
    List<MantanModel> listMantan = new ArrayList<>();

    int foto_1 = R.drawable.d_anya;
    int foto_2 = R.drawable.d_feby;
    int foto_3 = R.drawable.d_gabriel;
    int foto_4 = R.drawable.d_jennie;
    int foto_5 = R.drawable.d_kimihime;
    int foto_6 = R.drawable.d_pleng;
    int foto_7 = R.drawable.d_rose;
    int foto_8 = R.drawable.d_seleb;
    int foto_9 = R.drawable.d_tania;
    int foto_10 = R.drawable.d_thai;
    int foto_11 = R.drawable.d_tutut;
    int foto_12 = R.drawable.d_weigel;

    @Override
    protected void attachBaseContext(Context newBase){
        super.attachBaseContext(LocaleHelper.onAttach(newBase,"in"));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Daftar Mantan");

        Paper.init(this);
        String language = Paper.book().read("language");
        if(language == null)
            Paper.book().write("language","in");
        updateView((String)Paper.book().read("language"));

        //set myDb as DatabaseHelper class
        myDbEx = new DatabaseHelperEx(this);
        initRecyclerView();
    }

    //add data mantan
//    public void addDataEx(String nama, String asal, String keahlian, int foto){;
//        myDbEx.insertData(nama,asal,keahlian, foto);
//    }

    public void initRecyclerView(){
        adapter = new MantanAdapter(this);
        rv = findViewById(R.id.rv_movie);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
        rv.setNestedScrollingEnabled(false);
        rv.hasFixedSize();
        adapter.setOnItemClickListener(new MantanAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent i = new Intent(MainActivity.this, DetailMantanActivity.class);
                i.putExtra("nama",listMantan.get(position).getName());
                i.putExtra("asal",listMantan.get(position).getAsal());
                i.putExtra("keahlian",listMantan.get(position).getKeahlian());
                i.putExtra("deskripsi",listMantan.get(position).getDesCription());
                i.putExtra("foto",listMantan.get(position).getFotoMantan());
                startActivity(i);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            }
        });
        loadItem();
    }
    public void loadItem(){

        listMantan.add(new MantanModel(" Siti Wahabi",getString(R.string.asal) + " Lampung",getString(R.string.keahlian) +" "+ getString(R.string.bela_diri),getString(R.string.foto1),foto_1));
        listMantan.add(new MantanModel(" Hamba Sholeha",getString(R.string.asal) + " Jakarta",getString(R.string.keahlian) +" "+ getString(R.string.bela_umat),getString(R.string.foto2),foto_2));
        listMantan.add(new MantanModel(" Gina Amelia",getString(R.string.asal) + " Magelang",getString(R.string.keahlian) +" "+ getString(R.string.memasak),getString(R.string.foto3),foto_3));
        listMantan.add(new MantanModel(" Nindi Bahenol",getString(R.string.asal) + " Makassar",getString(R.string.keahlian) +" "+ getString(R.string.bernyanyi),getString(R.string.foto4),foto_4));
        listMantan.add(new MantanModel(" Sonya Latjuba",getString(R.string.asal) + " Palembang",getString(R.string.keahlian) +" "+ getString(R.string.berlari),getString(R.string.foto5),foto_5));
        listMantan.add(new MantanModel(" Raisa Apun",getString(R.string.asal) + " Bandung",getString(R.string.keahlian) +" "+ getString(R.string.menghisap),getString(R.string.foto6),foto_6));
        listMantan.add(new MantanModel(" Hinata Uzumaki",getString(R.string.asal) + " Karawang",getString(R.string.keahlian) +" "+ getString(R.string.memakan),getString(R.string.foto7),foto_7));
        listMantan.add(new MantanModel(" Sakura Uchiha",getString(R.string.asal) + " Bogor",getString(R.string.keahlian) +" "+ getString(R.string.jajan),getString(R.string.foto8),foto_8));
        listMantan.add(new MantanModel(" Istrinya Rektor",getString(R.string.asal) + " Bekasi",getString(R.string.keahlian) +" "+ getString(R.string.belanja),getString(R.string.foto9),foto_9));
        listMantan.add(new MantanModel(" Istrinya Dekan",getString(R.string.asal) + " Depok",getString(R.string.keahlian) +" "+ getString(R.string.marah_marah),getString(R.string.foto10),foto_10));
        listMantan.add(new MantanModel(" Istrinya Kajur",getString(R.string.asal) + " Ternate",getString(R.string.keahlian) +" "+ getString(R.string.memeluk),getString(R.string.foto11),foto_11));
        listMantan.add(new MantanModel(" Istrinya Kamu",getString(R.string.asal) + " Padang",getString(R.string.keahlian) +" "+ getString(R.string.mutusin),getString(R.string.foto12),foto_12));
        adapter.addAll(listMantan);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menuku, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.profilku){
            Intent i = new Intent(MainActivity.this,ProfileActivity.class);
            startActivity(i);
            overridePendingTransition(R.anim.goup,R.anim.godown);
        }
        else if (item.getItemId() == R.id.changeku){ }
        else if(item.getItemId() == R.id.subitem1){
            Paper.book().write("language","in");
            Toast.makeText(this,"Bahasa dipilih", Toast.LENGTH_SHORT).show();
            updateView((String)Paper.book().read("language"));
            finish();
            startActivity(getIntent());
            overridePendingTransition(R.anim.fadein,R.anim.fadeout);
        }
        else if(item.getItemId() == R.id.subitem2){
            Paper.book().write("language","en");
            Toast.makeText(this,"Language Choosed", Toast.LENGTH_SHORT).show();
            updateView((String)Paper.book().read("language"));
            finish();
            startActivity(getIntent());
            overridePendingTransition(R.anim.fadein,R.anim.fadeout);
        }
        else{
            super.onOptionsItemSelected(item);
        }
        return true;
    }

    private void updateView(String lang){
        LocaleHelper.setLocale(this,lang);
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Keluar Aplikasi")
                .setMessage("Tinggalkan Mantan?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("Tidak", null)
                .show();
    }
}
