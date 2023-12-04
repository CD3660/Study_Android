package com.example.and10_fragmentadapter.listv;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.and10_fragmentadapter.R;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class ListBaseAdapter extends BaseAdapter {
    LayoutInflater inflater;
    ArrayList<ListDTO> list;

    public ListBaseAdapter(LayoutInflater inflater, ArrayList<ListDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View v, ViewGroup parent) {
        Log.d("리스트뷰", "getView: "+v+" i :"+i);
        v = inflater.inflate(R.layout.item_listv, parent, false);
        ImageView imgvProfile = v.findViewById(R.id.imgv);
        TextView tv_name = v.findViewById(R.id.tv_1);
        TextView tv_age = v.findViewById(R.id.tv_2);
        TextView tv_gender = v.findViewById(R.id.tv_3);
        Button btn_odd = v.findViewById(R.id.btn_odd);
        imgvProfile.setImageResource(list.get(i).getImgRes());
        tv_name.setText("이름: "+list.get(i).getName());
        tv_age.setText("나이: "+list.get(i).getAge());
        tv_gender.setText("성별: "+list.get(i).getGender());
        btn_odd.setOnClickListener(v1 -> {

        });

        return v;
    }
}
