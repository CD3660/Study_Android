package com.example.project02_last.customer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project02_last.R;
import com.example.project02_last.common.CommonConn;
import com.example.project02_last.databinding.FragmentCustomerBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;


public class CustomerFragment extends Fragment {
    FragmentCustomerBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCustomerBinding.inflate(inflater, container, false);

        new CommonConn(getContext(), "customer.cu").onExcute((isResult, data) -> {
            List<CustomerDTO> list = new Gson().fromJson(data, new TypeToken<List<CustomerDTO>>(){}.getType());

            binding.recvCustomer.setAdapter(new CustomerRecvAdapter(list));
            binding.recvCustomer.setLayoutManager(new LinearLayoutManager(getContext()));
        });





        return binding.getRoot();
    }

}