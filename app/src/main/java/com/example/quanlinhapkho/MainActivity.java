package com.example.quanlinhapkho;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
ImageButton kho,vattu,phieunhap,ctphieunhap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__main);
        setControl();
        setEvent();
    }
    private void setControl(){
        kho=findViewById(R.id.kho);
        vattu=findViewById(R.id.vattu);
        phieunhap=findViewById(R.id.phieunhap);
        ctphieunhap=findViewById(R.id.ctpn);
    }
    private void setEvent(){
        vattu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), MainActivity_vattu.class);
                startActivity(nextScreen);
            }
        });
        kho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(getApplicationContext(), QuanLyKho.class);
                startActivity(nextScreen);
            }
        });
    }

}