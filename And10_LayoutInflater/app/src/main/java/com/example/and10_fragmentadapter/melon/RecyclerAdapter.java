package com.example.and10_fragmentadapter.melon;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.and10_fragmentadapter.R;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    LayoutInflater inflater;
    ArrayList<MelonDTO> list;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.music_listv, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int i) {
        h.music_imgv.setImageResource(list.get(i).getMusicImgRes());
        h.tv_music_rank.setText(i+"");
        h.tv_music_name.setText(list.get(i).getName());
        h.tv_music_artist.setText(list.get(i).getArtist());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView music_imgv;
        TextView tv_music_rank, tv_music_name, tv_music_artist;
        public ViewHolder(@NonNull View v) {
            super(v);
            music_imgv = v.findViewById(R.id.music_imgv);
            tv_music_rank = v.findViewById(R.id.tv_rank);
            tv_music_name = v.findViewById(R.id.tv_music_name);
            tv_music_artist = v.findViewById(R.id.tv_music_artist);
        }
    }

    public RecyclerAdapter(LayoutInflater inflater, ArrayList<MelonDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }
}
