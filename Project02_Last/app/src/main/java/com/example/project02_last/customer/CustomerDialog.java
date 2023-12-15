package com.example.project02_last.customer;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.example.project02_last.common.CommonConn;
import com.example.project02_last.databinding.DialogCustomerUpdateBinding;
import com.google.gson.Gson;

public class CustomerDialog extends Dialog {

    DialogCustomerUpdateBinding binding;
    public CustomerDialog(@NonNull Context context, CustomerVO vo) {
        super(context);
        binding = DialogCustomerUpdateBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setCancelable(false);
        binding.tvCusId.setText("고객번호:"+vo.getCustomer_id());
        binding.edtName.setText(vo.getName());
        binding.edtEmail.setText(vo.getEmail());
        binding.btnCancle.setOnClickListener(v -> {
            dismiss();
        });
        binding.btnUpdate.setOnClickListener(v -> {
            vo.setName(binding.edtName.getText().toString());
            vo.setEmail(binding.edtEmail.getText().toString());

            new CommonConn(context, "update.cu")
                    .addParamMap("customerVO",new Gson().toJson(vo))
                    .onExcute((isResult, data) -> {
                        dismiss();//다이얼로그 숨기기
                    });
        });



    }

}
