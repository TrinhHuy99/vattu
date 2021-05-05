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

public class UpdateVattu extends AppCompatActivity {
    final String DATABASE_NAME = "QUANLYKHOVATTU.db";
    Button btn_Luu, btn_Thoat;
    EditText edt_Ten, edt_Xuatxu;
    String maVt=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_vattu);
        btn_Luu = findViewById(R.id.buttonLuu);
        btn_Thoat = findViewById(R.id.buttonThoat);
        edt_Ten = findViewById(R.id.editTextTen);
        edt_Xuatxu = findViewById(R.id.editTextXuatXu);
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
        maVt = intent.getStringExtra("MAVT");
        SQLiteDatabase database = Database.initDatabase(this, DATABASE_NAME);
        Cursor cursor = database.rawQuery("Select * from VATTU WHERE MAVT=?", new String[]{maVt});
        cursor.moveToFirst();
        String ten = cursor.getString(1);
        String xuatXu = cursor.getString(2);
        edt_Ten.setText(ten);
        edt_Xuatxu.setText(xuatXu);
    }

    private void Update() {
        String ten = edt_Ten.getText().toString();
        String xuatxu = edt_Xuatxu.getText().toString();
        ContentValues contentValues = new ContentValues();
        contentValues.put("TENVT", ten);
        contentValues.put("XUATXU", xuatxu);
        SQLiteDatabase database = Database.initDatabase(this, "QUANLINHAPKHO.db");
        database.update("VATTU", contentValues, "MAVT=?", new String[]{maVt});
        Intent intent = new Intent(this, MainActivity_vattu.class);
        startActivity(intent);
    }
    private void Cancel(){
        Intent intent = new Intent(this, MainActivity_vattu.class);
        startActivity(intent);
    }
}