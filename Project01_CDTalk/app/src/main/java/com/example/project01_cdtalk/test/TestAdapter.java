package com.example.project01_cdtalk.test;


import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_cdtalk.R;
import com.example.project01_cdtalk.databinding.ItemFriendRecvBinding;
import com.example.project01_cdtalk.databinding.ItemRecvChatBinding;
import com.example.project01_cdtalk.friend.FriendDTO;
import com.example.project01_cdtalk.friend.FriendDetailActivity;

import java.util.ArrayList;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {

    LayoutInflater inflater;
    ArrayList<FriendDTO> list;
    Context context;

    public TestAdapter(LayoutInflater inflater, ArrayList<FriendDTO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFriendRecvBinding binding = ItemFriendRecvBinding.inflate(inflater, parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.tvFriendName.setText(list.get(i).getName());
        h.binding.tvFriendMsg.setText(list.get(i).getMsg());
        h.binding.imgvFriendProfile.setImageResource(list.get(i).getProfileImg());
        h.binding.lnFriend.setOnClickListener(v -> {
            Intent intent = new Intent(context, FriendDetailActivity.class);
            intent.putExtra("data", list.get(i));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemFriendRecvBinding binding;
        public ViewHolder(@NonNull ItemFriendRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
