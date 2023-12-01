package com.example.and10_fragmentadapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Button;

import com.example.fragments.MyFragment;
import com.example.fragments.MyFragment2;
import com.example.fragments.MyFragment3;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.btn_frag1);
        Button btn2 = findViewById(R.id.btn_frag2);
        Button btn3 = findViewById(R.id.btn_frag3);
        Fragment fragment =  new MyFragment();
        Fragment fragment2 =  new MyFragment2();
        Fragment fragment3 =  new MyFragment3();

        btn1.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
        });
        btn2.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();
        });
        btn3.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment3).commit();
        });

    }
}