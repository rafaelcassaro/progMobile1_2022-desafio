package com.example.pi.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.pi.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, ListaPedidosActivity.class);
                startActivity(i);
                finish();
            }
        }, 2000);
    }
/*
    @Override
    protected void onRestart(){
        super.onRestart();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(MainActivity.this, ListaPedidosActivity.class);
                startActivity(i);
            }
        }, 1000);
    }*/

}