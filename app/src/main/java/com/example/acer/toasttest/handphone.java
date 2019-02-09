package com.example.acer.toasttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class handphone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handphone);

        if (getSupportActionBar() != null)
        {
            getSupportActionBar().setTitle("Google pixle");
        }
        //nama action bar (judul)
    }
}
