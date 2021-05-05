package com.example.quanlinhapkho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddKho extends AppCompatActivity {

    final String DATABASE_NAME = "QUANLYKHOVATTU.db";
    Button btn_Luu, btn_Thoat;
    EditText edt_Makho,edt_Tenkho;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_kho);
        btn_Luu = findViewById(R.id.luu);
        btn_Thoat = findViewById(R.id.thoat);
        edt_Makho=findViewById(R.id.mkho);
        edt_Tenkho = findViewById(R.id.tkho);
        btn_Luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Insert();
            }
        });
        btn_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cancel();
            }
        });
    }
    private void Insert() {
        String makho=edt_Makho.getText().toString();
        String tenkho = edt_Tenkho.getText().toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MAKHO",makho);
        contentValues.put("TENKHO", tenkho);
        SQLiteDatabase database = Database.initDatabase(this, "QUANLINHAPKHO.db");
        database.insert("KHO",null, contentValues );
        Intent intent = new Intent(this, QuanLyKho.class);
        startActivity(intent);
    }
    private void Cancel(){
        Intent intent = new Intent(this, QuanLyKho.class);
        startActivity(intent);
    }
}