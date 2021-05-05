package com.example.quanlinhapkho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddVattu extends AppCompatActivity {
    final String DATABASE_NAME = "QUANLYKHOVATTU.db";
    Button btn_Luu, btn_Thoat;
    EditText edt_Mavt,edt_Ten, edt_Xuatxu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vattu);
        btn_Luu = findViewById(R.id.luu);
        btn_Thoat = findViewById(R.id.thoat);
        edt_Mavt=findViewById(R.id.mvt);
        edt_Ten = findViewById(R.id.tvt);
        edt_Xuatxu = findViewById(R.id.xx);
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
        String mavt=edt_Mavt.getText().toString();
        String ten = edt_Ten.getText().toString();
        String xuatxu = edt_Xuatxu.getText().toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MAVT",mavt);
        contentValues.put("TENVT", ten);
        contentValues.put("XUATXU", xuatxu);
        SQLiteDatabase database = Database.initDatabase(this, "QUANLINHAPKHO.db");
        database.insert("VATTU",null, contentValues );
        Intent intent = new Intent(this, MainActivity_vattu.class);
        startActivity(intent);
    }
    private void Cancel(){
        Intent intent = new Intent(this, MainActivity_vattu.class);
        startActivity(intent);
    }
}