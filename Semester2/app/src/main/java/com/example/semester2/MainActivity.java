package com.example.semester2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText user = findViewById(R.id.user);
        EditText pass = findViewById(R.id.pass);
        Button btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent inten = new Intent(getApplicationContext(),MainActivity2.class);
//                inten.putExtra("username",user.getText().toString());
//                inten.putExtra("pass",pass.getText().toString());
//                startActivity(inten);

                Bundle bungkus = new Bundle();
                bungkus.putString("username",user.getText().toString() );
                bungkus.putString("pass",pass.getText().toString());

                Intent inten = new Intent(MainActivity.this,MainActivity2.class);
                inten.putExtras(bungkus);
                startActivity(inten);
            }
        });


    }
}