package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlite.model.DAOPeserta;
import com.example.sqlite.model.Peserta;

public class FormPeserta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_peserta);

        Peserta peserta = new Peserta();
        DAOPeserta dao = new DAOPeserta(getApplicationContext());

        EditText nip = findViewById(R.id.nip);
        EditText nama = findViewById(R.id.nama);
        EditText email = findViewById(R.id.email);
        EditText instansi = findViewById(R.id.instansi);
        Button btnSimpan = findViewById(R.id.simpan);

        Bundle bundle = getIntent().getExtras();
        nip.setText(bundle.getString("nip"));
        nama.setText(bundle.getString("nama"));
        email.setText(bundle.getString("email"));
        instansi.setText(bundle.getString("instansi"));


        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                peserta.setId(bundle.getLong("id"));
                peserta.setNIP(nip.getText().toString());
                peserta.setNama(nama.getText().toString());
                peserta.setEmail(email.getText().toString());
                peserta.setInstansi(instansi.getText().toString());

                Toast.makeText(FormPeserta.this, "" + peserta.getNama(), Toast.LENGTH_SHORT).show();
                dao.update(peserta);

                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });


    }
}