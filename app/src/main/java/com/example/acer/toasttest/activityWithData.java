package com.example.acer.toasttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class activityWithData extends AppCompatActivity {
    TextView tv_data;
    public static final String EXTRA_AGE = "test_age";
    public static final String EXTRA_NAME = "test_name";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_data);
        tv_data = findViewById(R.id.pindah_dgn_data);

        String name = getIntent().getStringExtra(EXTRA_NAME);
        int age = getIntent().getIntExtra(EXTRA_AGE,0);

        String text ="name  = "+name+" age = "+age;
        tv_data.setText(text);
    }
}
