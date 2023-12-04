package com.example.and10_fragmentadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.and10_fragmentadapter.gridv.GridFragment;
import com.example.and10_fragmentadapter.listv.ListBaseFragment;
import com.example.and10_fragmentadapter.listv.ListFragment;
import com.example.and10_fragmentadapter.recycler.RecyclerFragment;

public class AdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);

        Button btn_list1 = findViewById(R.id.btn_list1);
        Button btn_list2 = findViewById(R.id.btn_list2);
        Button btn_grid = findViewById(R.id.btn_grid);
        Button btn_recycler = findViewById(R.id.btn_recycler);

        btn_list1.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new ListFragment()).commit();
        });
        btn_list2.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new ListBaseFragment()).commit();
        });
        btn_grid.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new GridFragment()).commit();
        });
        btn_recycler.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new RecyclerFragment()).commit();
        });


    }
}