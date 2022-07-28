package com.example.semester2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class AppMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_menu);

        ListView lv = findViewById(R.id.lv_float);
        //registrai lv untuk context menu
        registerForContextMenu(lv);

        String[] listKegiatan = new String[]{
                "Belanja","Olahraga","Tidur","Main Game","Pura Pura Ngoding","Nyuci","Makan"
        };

        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1, listKegiatan);

        lv.setAdapter(adapter);

        //POPUP MENU
        //bainding btnpopup dari xml file
        Button btnPopup = findViewById(R.id.btn_popup);
        //membuat event handler untuk btnPopup
        btnPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //buat object dari class popupmenu
                PopupMenu popupMenu = new PopupMenu(AppMenu.this,btnPopup);
                //inflate isi popup menggunakan xml file
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                //registrasi menggunakan onMenuItemClickListener
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        Toast.makeText(AppMenu.this, "Anda menekan : "+ menuItem.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

    }

    //APP MENU
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
            case R.id.bookmark:
                Toast.makeText(this, "Anda menekan tombol bookmark", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.history:
                Toast.makeText(this, "Anda menekan tombol history", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.setting:
                Toast.makeText(this, "Anda menekan tombol setting", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.logout:
                Toast.makeText(this, "Anda menekan tombol logout", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    //implementasi onCreateContextMenu untuk floating menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.popup_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        String title  = item.getTitle().toString();
        Toast.makeText(this, "Anda memilih menu " + title, Toast.LENGTH_SHORT).show();
        return true;
    }
}