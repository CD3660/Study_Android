package com.example.and10_fragmentadapter.melon;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.and10_fragmentadapter.R;

import java.util.ArrayList;

public class RecyclerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recycler2, container, false);
        RecyclerView recv = v.findViewById(R.id.music_recv);
        ArrayList<MelonDTO> list = new ArrayList<>();
        RecyclerAdapter adapter = new RecyclerAdapter(inflater,list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recv.setLayoutManager(manager);
        recv.setAdapter(adapter);



        return v;
    }
}