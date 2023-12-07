package com.example.and10_fragmentadapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CDViewHolder extends RecyclerView.ViewHolder {
    ImageView imgv;
    TextView tv_1, tv_2, tv_3;
    public CDViewHolder(@NonNull View v) {
        super(v);
        this.imgv = v.findViewById(R.id.imgv);
        this.tv_1 = v.findViewById(R.id.tv_1);
        this.tv_2 = v.findViewById(R.id.tv_2);
        this.tv_3 = v.findViewById(R.id.tv_3);
    }
}