package com.example.project01_cdtalk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.project01_cdtalk.databinding.ActivityMainaaBinding;

public class MainaaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainaaBinding binding = ActivityMainaaBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setContentView(R.layout.activity_mainaa);

    }
}