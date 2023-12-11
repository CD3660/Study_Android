package com.example.project01_cdtalk.opentalk;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_cdtalk.databinding.ItemOpentalkChat1Binding;
import com.example.project01_cdtalk.databinding.ItemOpentalkChat2Binding;

import java.util.ArrayList;

public class OpenSub3Adapter extends RecyclerView.Adapter<OpenSub3Adapter.OpenSub3ViewHolder> {
    ArrayList<OpenSubDTOs.OpenSub3DTO> list;
    public OpenSub3Adapter(ArrayList<OpenSubDTOs.OpenSub3DTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public OpenSub3ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemOpentalkChat2Binding binding = ItemOpentalkChat2Binding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new OpenSub3ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull OpenSub3ViewHolder h, int i) {
        h.binding.roomTitle.setText(list.get(i).getRoomTitle());
        h.binding.background.setBackgroundResource(list.get(i).getBackgroundImgRes());
        h.binding.cntRecent.setText(list.get(i).getChatCnt()+" "+list.get(i).getRecentChat());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class OpenSub3ViewHolder extends RecyclerView.ViewHolder{
        ItemOpentalkChat2Binding binding;
        public OpenSub3ViewHolder(@NonNull ItemOpentalkChat2Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
