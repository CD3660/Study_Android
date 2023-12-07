package com.example.project01_cdtalk.friend;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_cdtalk.databinding.ItemFriendRecvBinding;

import java.util.ArrayList;

public class FriendRecvAdapter extends RecyclerView.Adapter<FriendRecvAdapter.CDViewHolder> {
    LayoutInflater inflater;
    ArrayList<FriendDTO> list;
    Context context;

    public FriendRecvAdapter(LayoutInflater inflater, ArrayList<FriendDTO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CDViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFriendRecvBinding binding = ItemFriendRecvBinding.inflate(inflater, parent, false);
        return new CDViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CDViewHolder h, int i) {
        h.binding.imgvFriendProfile.setImageResource(list.get(i).getProfileImg());
        h.binding.tvFriendName.setText(list.get(i).getName());
        h.binding.tvFriendMsg.setText(list.get(i).getMsg());
        h.binding.lnFriend.setOnClickListener(v -> {
            Intent intent = new Intent(context, FriendDetailActivity.class);
            intent.putExtra("dto", list.get(i));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CDViewHolder extends RecyclerView.ViewHolder {
        ItemFriendRecvBinding binding;
        public CDViewHolder(@NonNull ItemFriendRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
