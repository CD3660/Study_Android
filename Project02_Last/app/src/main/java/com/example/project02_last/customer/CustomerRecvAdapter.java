package com.example.project02_last.customer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_last.databinding.ItemRecvCustomerBinding;

import java.util.ArrayList;
import java.util.List;

public class CustomerRecvAdapter extends RecyclerView.Adapter<CustomerRecvAdapter.CustomerViewHolder> {
    List<CustomerDTO> list;

    public CustomerRecvAdapter(List<CustomerDTO> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecvCustomerBinding binding = ItemRecvCustomerBinding.inflate(LayoutInflater.from(parent.getContext()),parent, false);
        return new CustomerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder h, int i) {
        h.binding.customerId.setText(list.get(i).getCustomer_id()+"");
        h.binding.name.setText(list.get(i).getName());
        h.binding.gender.setText(list.get(i).getGender());
        h.binding.email.setText(list.get(i).getEmail());
        h.binding.phone.setText(list.get(i).getPhone());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder{
        ItemRecvCustomerBinding binding;
        public CustomerViewHolder(@NonNull ItemRecvCustomerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
