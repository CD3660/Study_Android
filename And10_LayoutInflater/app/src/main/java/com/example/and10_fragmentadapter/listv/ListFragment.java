package com.example.and10_fragmentadapter.listv;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.and10_fragmentadapter.R;


public class ListFragment extends Fragment {
    ListView listv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_list, container, false);
        String[] arr = new String[10];
        for (int i = 0; i<arr.length; i++){
            arr[i] = "글자"+i;
        }
        ArrayAdapter adapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, arr);


        listv = v.findViewById(R.id.listv);
        listv.setAdapter(adapter);
        return v;
    }
}