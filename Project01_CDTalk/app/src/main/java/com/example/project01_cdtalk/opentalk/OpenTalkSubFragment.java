package com.example.project01_cdtalk.opentalk;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_cdtalk.databinding.FragmentOpenTalkSubBinding;
import com.google.android.material.chip.Chip;


public class OpenTalkSubFragment extends Fragment {
    FragmentOpenTalkSubBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOpenTalkSubBinding.inflate(inflater, container, false);
        OpenSubDAO dao = new OpenSubDAO();
        binding.recvOpensub1.setAdapter(new OpenSub1Adapter(dao.getOpenSub1List()));
        binding.recvOpensub1.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.recvOpensub2.setAdapter(new OpenSub2Adapter(dao.getOpenSub2List1()));
        binding.recvOpensub2.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.recvOpensub3.setAdapter(new OpenSub2Adapter(dao.getOpenSub2List2()));
        binding.recvOpensub3.setLayoutManager(new LinearLayoutManager(getContext()));

        binding.recvOpensub4.setAdapter(new OpenSub3Adapter(dao.getOpenSub3List()));
        binding.recvOpensub4.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false));

        initChip();

        return binding.getRoot();
    }
    public Chip getChip(String text){
        Chip chip = new Chip(getContext(),null, com.google.android.material.R.style.Widget_MaterialComponents_Chip_Choice);
        chip.setText(text);
        chip.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT));
        return chip;
    }
    public void initChip(){
        String[] chipTexts = {"해외축구", "정국", "레고", "닌텐도", "밀덕","손흥민", "라이즈", "아르바이트", "등산", "이영지", "동화책", "조승연"};
        for (String text:chipTexts) {
            binding.chipGroupSub.addView(getChip(text));
        }
    }
}