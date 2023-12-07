package com.example.and10_fragmentadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CDRecycleAdapter extends RecyclerView.Adapter<CDViewHolder> {
    LayoutInflater inflater;


    @NonNull
    @Override
    public CDViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CDViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
