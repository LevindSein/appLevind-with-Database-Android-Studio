package com.example.levindmopro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.levindmopro.helper.LocaleHelper;

import java.util.Objects;

import io.paperdb.Paper;

public class DetailMantanActivity extends AppCompatActivity {
    ImageView imgView;
    TextView mNama;
    TextView mAsal;
    TextView mKeahlian;
    TextView mDesc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mantan);
        setTitle("Detail Mantan");
        setData();
    }

    public void setData(){

        imgView = findViewById(R.id.img);
        mNama = findViewById(R.id.txt_name_mantan);
        mAsal = findViewById(R.id.txt_asal);
        mKeahlian = findViewById(R.id.txt_keahlian);
        mDesc = findViewById(R.id.txt_deskripsi);

        mNama.setText(getIntent().getStringExtra("nama"));
        mAsal.setText(getIntent().getStringExtra("asal"));
        mKeahlian.setText(getIntent().getStringExtra("keahlian"));
        mDesc.setText(getIntent().getStringExtra("deskripsi"));
        imgView.setImageResource(getIntent().getIntExtra("foto",0));
    }
}
