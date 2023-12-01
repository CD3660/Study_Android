package com.example.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.and10_fragmentadapter.R;

public class MyFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my, container, false);
        Button btn_myfrag1 = v.findViewById(R.id.btn_myfrag1);
        btn_myfrag1.setOnClickListener(v1 -> {
            btn_myfrag1.setText("버튼 클릭이 되었습니다.");
        });



        return v;
    }


}