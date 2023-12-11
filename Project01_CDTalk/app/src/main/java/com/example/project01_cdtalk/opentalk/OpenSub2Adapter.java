package com.example.project01_cdtalk.opentalk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_cdtalk.databinding.ItemOpentalkChat1Binding;
import com.example.project01_cdtalk.databinding.ItemRecvChatBinding;

import java.util.ArrayList;

public class OpenSub2Adapter extends RecyclerView.Adapter<OpenSub2Adapter.OpenSub2ViewHolder> {
    ArrayList<OpenSubDTOs.OpenSub2DTO> list;
    public OpenSub2Adapter(ArrayList<OpenSubDTOs.OpenSub2DTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public OpenSub2ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemOpentalkChat1Binding binding = ItemOpentalkChat1Binding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new OpenSub2ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull OpenSub2ViewHolder h, int i) {
        h.binding.roomTitle.setText(list.get(i).getRoomTitle());
        h.binding.imgvProfile.setImageResource(list.get(i).getImgTitle());
        String tagStr = "";
        for (String str:list.get(i).getTagArr()) {
            tagStr += "#"+str+" ";
        }
        h.binding.tagArr.setText(String.join("#",list.get(i).getTagArr()));
        h.binding.chatCnt.setText(list.get(i).getChatCnt()+"명 참여중");
        h.binding.recent.setText(list.get(i).getRecentChat());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class OpenSub2ViewHolder extends RecyclerView.ViewHolder{
        ItemOpentalkChat1Binding binding;
        public OpenSub2ViewHolder(@NonNull ItemOpentalkChat1Binding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
