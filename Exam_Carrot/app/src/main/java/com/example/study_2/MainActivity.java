package com.example.study_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imgv_profile;
    TextView tv_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgv_profile = findViewById(R.id.imgv_prifile);
        imgv_profile.setOnClickListener(v->{
            Log.d("이미지 클릭", "cd");
        });
        tv_main = findViewById(R.id.tv_main);
        tv_main.setOnClickListener(v -> {
            Log.d("fff", "onCreate: ");
        });


    }
}