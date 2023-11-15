package com.example.and05_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btn_next, btn_prev;
    ImageView imgv1, imgv2, imgv3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_next = findViewById(R.id.btn_next);
        btn_prev = findViewById(R.id.btn_prev);
        imgv1 = findViewById(R.id.imgv1);
        imgv2 = findViewById(R.id.imgv2);
        imgv3 = findViewById(R.id.imgv3);
        btn_next.setOnClickListener(v->{
            if(imgv1.getVisibility()== View.VISIBLE){
                imgv1.setVisibility(View.GONE);
                imgv2.setVisibility(View.VISIBLE);
                Log.d("CD log", "이미지 변경 ->2");
            } else if (imgv2.getVisibility()==View.VISIBLE){
                imgv2.setVisibility(View.GONE);
                imgv3.setVisibility(View.VISIBLE);
                Log.d("CD log", "이미지 변경 ->3");
            } else if (imgv3.getVisibility()==View.VISIBLE){
                imgv3.setVisibility(View.GONE);
                imgv1.setVisibility(View.VISIBLE);
                Log.d("CD log", "이미지 변경 ->1");
            }
        });
        btn_prev.setOnClickListener(v->{
            if(imgv1.getVisibility()== View.VISIBLE){
                imgv1.setVisibility(View.GONE);
                imgv3.setVisibility(View.VISIBLE);
                Log.d("CD log", "이미지 변경 ->3");
            } else if (imgv2.getVisibility()==View.VISIBLE){
                imgv2.setVisibility(View.GONE);
                imgv1.setVisibility(View.VISIBLE);
                Log.d("CD log", "이미지 변경 ->1");
            } else if (imgv3.getVisibility()==View.VISIBLE){
                imgv3.setVisibility(View.GONE);
                imgv2.setVisibility(View.VISIBLE);
                Log.d("CD log", "이미지 변경 ->2");
            }
        });
    }
}