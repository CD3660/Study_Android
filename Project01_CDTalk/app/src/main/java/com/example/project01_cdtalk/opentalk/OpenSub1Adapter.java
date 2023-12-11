package com.example.project01_cdtalk.opentalk;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_cdtalk.databinding.ItemRecvChatBinding;

import java.util.ArrayList;

public class OpenSub1Adapter extends RecyclerView.Adapter<OpenSub1Adapter.OpenSub1ViewHolder> {
    ArrayList<OpenSubDTOs.OpenSub1DTO> list;

    public OpenSub1Adapter(ArrayList<OpenSubDTOs.OpenSub1DTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public OpenSub1ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecvChatBinding binding = ItemRecvChatBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new OpenSub1ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull OpenSub1ViewHolder h, int i) {
        h.binding.imgvProfile.setImageResource(list.get(i).getImgTitle());
        h.binding.roomTitle.setText(list.get(i).getRoomTitle());
        h.binding.chatCnt.setText(list.get(i).getChatCnt()+"");
        h.binding.recentChat.setText(list.get(i).getRecentChat());
        h.binding.chatDate.setText(list.get(i).getChatDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class OpenSub1ViewHolder extends RecyclerView.ViewHolder{
        ItemRecvChatBinding binding;
        public OpenSub1ViewHolder(@NonNull ItemRecvChatBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
