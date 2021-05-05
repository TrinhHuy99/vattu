package com.example.quanlinhapkho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity_vattu extends AppCompatActivity {
    final String DATABASE_NAME = "QUANLYKHOVATTU.db";
    SQLiteDatabase database;

    ListView lv_VT;
    ArrayList<Vattu> list_VT;
    AdapterVatTu adapterVatTu;
    Button Them, Trangchu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_vattu);

        addControls();
        readData();
    }

    private void addControls() {
        lv_VT = findViewById((R.id.lv_vattu));
        list_VT = new ArrayList<>();
        adapterVatTu = new AdapterVatTu(this, list_VT);
        lv_VT.setAdapter(adapterVatTu);
        Them = findViewById(R.id.them);
        Trangchu=findViewById(R.id.trangchu);
        Them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_vattu.this, AddVattu.class);
                startActivity(intent);
            }
        });
        Trangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_vattu.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void readData() {
        database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("SELECT * from VATTU", null);
        list_VT.clear();
        for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            String maVT = cursor.getString(0);
            String tenVT = cursor.getString(1);
            String xuatXu = cursor.getString(2);
            byte[] hinh = cursor.getBlob(3);
            list_VT.add(new Vattu(maVT,tenVT,xuatXu,hinh));
        }
        adapterVatTu.notifyDataSetChanged();
    }

    private void setEvent() {
        Them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity_vattu.this, AddVattu.class);
                startActivity(intent);
            }
        });
    }
}