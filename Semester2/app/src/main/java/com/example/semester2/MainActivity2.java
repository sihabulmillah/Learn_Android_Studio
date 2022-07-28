package com.example.semester2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView text = findViewById(R.id.text2);
        TextView text2 = findViewById(R.id.text3);
//        text.setText(getIntent().getStringExtra("username"));
//        text2.setText(getIntent().getStringExtra("pass"));
        if(getIntent().getExtras() != null){
            Bundle bungkusan = getIntent().getExtras();
            text.setText(bungkusan.getString("username"));
            text2.setText(bungkusan.getString("pass"));
        }else{
            text.setText(getIntent().getStringExtra("username"));
            text2.setText(getIntent().getStringExtra("pass"));
        }
    }
}