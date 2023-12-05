package com.example.and10_fragmentadapter;

import static com.example.and10_fragmentadapter.R.*;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.and10_fragmentadapter.melon.RecyclerFragment;

public class RecyclerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_recycler);
        TextView tv_chart = findViewById(R.id.tv_chart);
        tv_chart.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(id.container, new RecyclerFragment()).commit();
            tv_chart.setTextColor(getResources().getColor(color.app_main_color));
        });
    }
}
