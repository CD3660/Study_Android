package com.example.and03_relativelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test1);
        setTest1();


    }
    public void setTest2(){
        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener((v)->{
            setContentView(R.layout.layout_test2);
            setTest1();
        });
    }
    public void setTest1(){
        Button btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener((v)->{
            setContentView(R.layout.layout_test1);
            setTest2();
        });
    }
}