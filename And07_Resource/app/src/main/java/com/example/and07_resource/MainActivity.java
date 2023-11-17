package com.example.and07_resource;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "메인 액티비티";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.carrot_layout);

        ImageView iv  = findViewById(R.id.profile);
        iv.setOnClickListener(v->{
            Log.d("CD", "프로필 클릭");
        });

    }
}