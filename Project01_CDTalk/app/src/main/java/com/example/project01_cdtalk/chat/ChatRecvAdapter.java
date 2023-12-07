package com.example.project01_cdtalk.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_cdtalk.databinding.ItemRecvChatBinding;

import java.util.ArrayList;

public class ChatRecvAdapter extends RecyclerView.Adapter<ChatRecvAdapter.ChatViewHolder> {
    LayoutInflater inflater;
    ArrayList<ChatDTO> list;
    Context context;

    public ChatRecvAdapter(LayoutInflater inflater, ArrayList<ChatDTO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecvChatBinding binding = ItemRecvChatBinding.inflate(inflater,parent,false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder {
        ItemRecvChatBinding binding;
        public ChatViewHolder(@NonNull ItemRecvChatBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
