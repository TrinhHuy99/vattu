package com.example.quanlinhapkho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

public class UpdateKho extends AppCompatActivity {
    final String DATABASE_NAME = "QUANLYKHOVATTU.db";
    Button btn_Luu, btn_Thoat;
    EditText edt_Tenkho;
    String maKho=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatekho);
        btn_Luu = findViewById(R.id.buttonLuu);
        btn_Thoat = findViewById(R.id.buttonThoat);
        edt_Tenkho = findViewById(R.id.edtTenkho);
        initUI();
        btn_Luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Update();
            }
        });
        btn_Thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cancel();
            }
        });
    }


    private void initUI() {
        Intent intent = getIntent();
        maKho = intent.getStringExtra("MAKHO");
        SQLiteDatabase database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("Select * from KHO WHERE MAKHO=?", new String[]{maKho});
        cursor.moveToFirst();
        String ten = cursor.getString(1);
        edt_Tenkho.setText(ten);
    }

    private void Update() {
        String ten = edt_Tenkho.getText().toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put("TENKHO", ten);
        SQLiteDatabase database = Database.initDatabase(this, "QUANLINHAPKHO.db");
        database.update("KHO", contentValues, "MAKHO=?", new String[]{maKho});
        Intent intent = new Intent(this, QuanLyKho.class);
        startActivity(intent);
    }
    private void Cancel(){
        Intent intent = new Intent(this, QuanLyKho.class);
        startActivity(intent);
    }
}