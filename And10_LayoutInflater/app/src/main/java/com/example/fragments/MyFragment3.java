package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.and10_fragmentadapter.R;

public class MyFragment3 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my3, container, false);
        Button btn_myfrag3 = v.findViewById(R.id.btn_myfrag3);
        TextView tv_myfrag3 = v.findViewById(R.id.tv_myfrag3);
        btn_myfrag3.setOnClickListener(v1 -> {
            tv_myfrag3.setText("버튼 눌림");
        });
        return v;
    }
}