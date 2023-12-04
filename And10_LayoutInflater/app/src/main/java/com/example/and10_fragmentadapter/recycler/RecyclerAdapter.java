package com.example.and10_fragmentadapter.recycler;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and10_fragmentadapter.R;
import com.example.and10_fragmentadapter.listv.ListDTO;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CDViewHolder> {
    LayoutInflater inflater;
    ArrayList<ListDTO> list;

    @NonNull
    @Override
    public CDViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CDViewHolder(inflater.inflate(R.layout.item_listv,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CDViewHolder h, int i) {
        h.img_v.setImageResource(list.get(i).getImgRes());
        h.tv_name.setText("이름: "+list.get(i).getName());
        h.tv_age.setText("나이: "+list.get(i).getAge());
        h.tv_gender.setText("성별: "+list.get(i).getGender());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CDViewHolder extends RecyclerView.ViewHolder {
        ImageView img_v;
        TextView tv_name, tv_age, tv_gender;
        public CDViewHolder(@NonNull View v) {
            super(v);
            img_v = v.findViewById(R.id.imgv);
            tv_name = v.findViewById(R.id.tv_1);
            tv_age = v.findViewById(R.id.tv_2);
            tv_gender = v.findViewById(R.id.tv_3);
        }
    }

    public RecyclerAdapter(LayoutInflater inflater, ArrayList<ListDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }
}
