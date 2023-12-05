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
        list.add(new MelonDTO("Perfect Night","LESSERAFIILM(르세라핌)",R.drawable.chart_img1));
        list.add(new MelonDTO("Drama","aespa",R.drawable.chart_img2));
        list.add(new MelonDTO("Baddie","IVE(아이브)",R.drawable.chart_img3));
        list.add(new MelonDTO("To. X","태연(TAEYEON)",R.drawable.chart_img4));
        list.add(new MelonDTO("사랑은 늘 도망가","임영웅",R.drawable.chart_img5));
        list.add(new MelonDTO("Seven(feat.Latto) - Clean Ver","정국",R.drawable.chart_img6));
        RecyclerAdapter adapter = new RecyclerAdapter(inflater,list);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext());
        recv.setLayoutManager(manager);
        recv.setAdapter(adapter);



        return v;
    }
}