package com.example.project02_last.customer;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project02_last.common.CommonConn;
import com.example.project02_last.databinding.FragmentCustomerBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;


public class CustomerFragment extends Fragment {
    FragmentCustomerBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCustomerBinding.inflate(inflater, container, false);

        select(null);
        binding.searchBar.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d("검색", "onQueryTextSubmit: " + query);
                select(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.d("검색", "onQueryTextChange: " + newText);
                if(newText.isEmpty()){
                    select("");
                }
                return true;
            }
        });


        return binding.getRoot();
    }


    void select(String query) {
        CommonConn conn = new CommonConn(getContext(), "customer.cu");
        if (query != null) {
            conn.addParamMap("query", query);
        }
        conn.onExcute((isResult, data) -> {
            List<CustomerVO> list = new Gson().fromJson(data, new TypeToken<List<CustomerVO>>() {
            }.getType());
            binding.recvCustomer.setAdapter(new CustomerRecvAdapter(list, getContext(), new CustomerRecvAdapter.CustomerCallBack() {
                @Override
                public void onResult() {
                    select(null);
                }
            }));
            binding.recvCustomer.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.fabInsert.setOnClickListener(v -> {
                Intent intent = new Intent(getContext(), CustomerInsertActivity.class);
                startActivity(intent);
            });
        });
    }

}