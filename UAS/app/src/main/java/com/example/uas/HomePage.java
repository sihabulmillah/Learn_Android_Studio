package com.example.uas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        String data = getIntent().getStringExtra("username");
        TextView user = (TextView) findViewById(R.id.user);

        user.setText(data);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_app_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                Toast.makeText(this, "Anda menekan tombol about", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.logout:
                Intent pindah = new Intent(HomePage.this,MainActivity.class);
                startActivity(pindah);
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
