package com.example.uas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.uas.helper.SqlActifity;
import com.example.uas.model.DAOUser;
import com.example.uas.model.Login;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    TextView lupa,settext;
    Button Btnmasuk;
    DAOUser dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        Btnmasuk = findViewById(R.id.masuk);
        lupa = findViewById(R.id.lupa);
        settext = findViewById(R.id.settext);

        dao = new DAOUser(this);

        Btnmasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString().trim();
                String pass = password.getText().toString().trim();

                Boolean test = dao.checkUser(user,pass);
                if(test == true){
                    Toast.makeText(MainActivity.this, "Login Succes Full", Toast.LENGTH_SHORT).show();
                    Intent masuk = new Intent(MainActivity.this, HomePage.class);
                    masuk.putExtra("username",user);
                    startActivity(masuk);
                    finish();
                }else {
                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        lupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               settext.setText("Coba inget inget :)");

            }
        });
    }
}