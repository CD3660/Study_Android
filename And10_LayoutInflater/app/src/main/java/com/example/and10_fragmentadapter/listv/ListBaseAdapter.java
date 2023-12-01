package com.example.and10_fragmentadapter.listv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.and10_fragmentadapter.R;

import java.util.zip.Inflater;


public class ListBaseAdapter extends BaseAdapter {
    LayoutInflater inflater;

    public ListBaseAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return 5;
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
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_listv, parent, false);

        return convertView;
    }
}
