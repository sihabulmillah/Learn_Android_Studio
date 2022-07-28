package com.example.projectkebututs;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        Button btnPindah2 = findViewById(R.id.btn_pindah3);
        Spinner spin = findViewById(R.id.spin);
        Button  btnAmbil = findViewById(R.id.btn_ambil);
        TextView txtNama = findViewById(R.id.data_nama);
        Resources list = getResources();
        String [] listAwal = list.getStringArray(R.array.nama);

        List<String> listNama = new ArrayList<String>();
        listNama.add("usman");
        listNama.add("Usup");
        listNama.addAll(Arrays.asList(listAwal));



        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, listNama );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        //
        btnAmbil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = spin.getSelectedItem().toString();
                txtNama.setText(nama);

                Toast.makeText(Activity3.this, "Position :  "+ spin.getSelectedItemPosition(), Toast.LENGTH_SHORT).show();
                Toast.makeText(Activity3.this, "ANDA MENGAMBIL Nama "+ spin.getSelectedItem(), Toast.LENGTH_SHORT).show();
            }
        });
        btnPindah2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hus = new Intent(Activity3.this,Activity2.class);
                startActivity(hus);
                finish();
            }
        });
    }
    }