package com.example.recvtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recvtest.databinding.ItemRecvBinding;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecvBinding binding = ItemRecvBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.binding.small.setText("글자 바뀜"+i);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ItemRecvBinding binding;
        public ViewHolder(@NonNull ItemRecvBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }


}
