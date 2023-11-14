package com.example.and02_intolayoutconst;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(this, "토스트창", Toast.LENGTH_SHORT).show();
//            }
//        });
//        람다식
        btn.setOnClickListener((v) -> {
            Toast.makeText(this, "토스트창", Toast.LENGTH_SHORT).show();
        });

    }

}