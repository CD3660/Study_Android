package com.example.project02_last.customer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.project02_last.R;
import com.example.project02_last.common.CommonConn;
import com.example.project02_last.databinding.ActivityCustomerInsertBinding;

public class CustomerInsertActivity extends AppCompatActivity {
    ActivityCustomerInsertBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCustomerInsertBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnIdCheck.setOnClickListener(v -> {
            CustomerIdCheckDialog dialog = new CustomerIdCheckDialog(this, () -> {
                finish();
            });
        });

    }
}