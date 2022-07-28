package com.example.projectkebututs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Activity2 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Button btnListener = findViewById(R.id.btn_listener);
        Button btnPindah = findViewById(R.id.btn_pindah);

        btnPindah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this,ActListView.class);
                startActivity(intent);
                finish();
            }
        });
//menggunakan listener interface
   btnListener.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String label = ((Button) view).getText().toString();
        Toast.makeText(this, "Anda Menekan Tombol" + label , Toast.LENGTH_SHORT).show();
    }

    public void Pencet(View view) {
        Toast.makeText(this, "Klik Uy", Toast.LENGTH_SHORT).show();
    }
}