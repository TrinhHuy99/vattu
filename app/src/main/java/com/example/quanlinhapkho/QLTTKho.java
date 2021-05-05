package com.example.quanlinhapkho;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class QLTTKho extends AppCompatActivity {

    final String DATABASE_NAME = "QUANLYKHOVATTU.db";
    SQLiteDatabase database;
    String maKho=null;
    ListView lv_TTKho;
    ArrayList<TTVatTu> list_ttKho;
    AdapterTTVatTu adapterTTVatTu;
    TextView tv_tenkho,tv_makho;
//    Button Them, Trangchu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tt_kho);

        addControls1();
        readData1();
    }

    private void addControls1() {
        lv_TTKho = findViewById((R.id.lv_TTKho));
        list_ttKho = new ArrayList<>();
        adapterTTVatTu = new AdapterTTVatTu(this, list_ttKho);
        lv_TTKho.setAdapter(adapterTTVatTu);
        tv_makho=findViewById(R.id.tv_ttMaKho);
        tv_tenkho=findViewById(R.id.tv_ttTenKho);
//        Trangchu=findViewById(R.id.trangchu);
    }

    private void readData1() {
        Intent intent = getIntent();
        maKho = intent.getStringExtra("MAKHO");
        SQLiteDatabase database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("Select * from KHO WHERE MAKHO=?", new String[]{maKho});
        cursor.moveToFirst();
        list_ttKho.clear();
        String maKho = cursor.getString(0);
        String tenKho = cursor.getString(1);
        tv_makho.setText("Mã kho: " +maKho);
        tv_tenkho.setText("Tên kho: "+tenKho);
//        int soPhieu;
//        cursor = database.rawQuery("Select SOPHIEU from KHO, PHIEUNHAP WHERE KHO.MAKHO=PHIEUNHAP.MAKHO AND KHO.MAKHO=?", new String[]{maKho});
//        for(int i = 0; i < cursor.getCount(); i++){
//            soPhieu = cursor.getInt(i);
//        }
//        soPhieu = cursor.getInt(0);
//
//        cursor = database.rawQuery("Select MAVT,TENVT,DVT,SOLUONG from KHO, PHIEUNHAP,VATTU WHERE SOPHIEU=?", new String[]{soPhieu+"",});
        /*for (int i = 0; i < cursor.getCount(); i++) {
            cursor.moveToPosition(i);
            String maKho = cursor.getString(0);
            String tenKho = cursor.getString(1);
            list_ttKho.add(new TTVatTu(maKho, tenKho));
        }*/
        adapterTTVatTu.notifyDataSetChanged();
    }

}
