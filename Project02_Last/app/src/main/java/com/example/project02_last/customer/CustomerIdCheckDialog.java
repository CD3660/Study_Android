package com.example.project02_last.customer;

import android.app.Dialog;
import android.content.Context;

import androidx.annotation.NonNull;

import com.example.project02_last.databinding.DialogIdCheckBinding;

public class CustomerIdCheckDialog extends Dialog {
    DialogIdCheckBinding binding;
    CallBack callBack;
    public CustomerIdCheckDialog(@NonNull Context context, CallBack callBack) {
        super(context);
        this.callBack = callBack;
        binding = DialogIdCheckBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnIdCheck.setOnClickListener(v -> {

        });
        binding.btnCancle.setOnClickListener(v -> {
            callBack.onResult();
        });

    }
    public interface CallBack{
        public void onResult();
    }
}
