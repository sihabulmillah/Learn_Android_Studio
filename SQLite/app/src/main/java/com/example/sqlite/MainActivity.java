package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sqlite.model.DAOPeserta;
import com.example.sqlite.model.Peserta;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    DAOPeserta dao;
    ListView listView;
    List<Peserta> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dao = new DAOPeserta(getApplicationContext());
        dao.open();

        listView = findViewById(R.id.list_peserta);
        list = dao.getAll();
        final ArrayAdapter<Peserta> adapter = new ArrayAdapter<Peserta>(this,android.R.layout.simple_list_item_1,list);
        listView.setAdapter(adapter);
        dao.closes();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Peserta obj = list.get(i); //i adalah index dari list
                Toast.makeText(MainActivity.this, "Anda memilih " + obj.getNama(), Toast.LENGTH_SHORT).show();

                Intent pindah = new Intent(getApplicationContext(),FormPeserta.class);
                pindah.putExtra("id",obj.getId());
                pindah.putExtra("nip",obj.getNIP());
                pindah.putExtra("nama",obj.getNama());
                pindah.putExtra("email",obj.getEmail());
                pindah.putExtra("instansi",obj.getInstansi());
                startActivity(pindah);

            }
        });
//
    }
}