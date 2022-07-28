package com.example.projectkebututs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ActListView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_list_view);

        Button btnPindah1 = findViewById(R.id.btn_pindah2);
        ListView list = findViewById(R.id.list_kegiatan);

        String[] listKegiatan = new String[]{
          "Belanja","Olahraga","Tidur","Main Game","Pura Pura Ngoding","Nyuci","Makan"
        };

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, listKegiatan);

        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "Kegiatan " + i + "\n" + listKegiatan[i], Toast.LENGTH_LONG).show();
            }
        });

        btnPindah1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ngalih = new Intent(ActListView.this,Activity3.class);
                startActivity(ngalih);
            }
        });
    }
}