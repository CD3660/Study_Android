package com.example.project02_last.customer;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project02_last.common.CommonConn;
import com.example.project02_last.databinding.ItemRecvCustomerBinding;

import java.util.List;

import javax.security.auth.callback.Callback;

public class CustomerRecvAdapter extends RecyclerView.Adapter<CustomerRecvAdapter.CustomerViewHolder> {
    List<CustomerVO> list;
    Context context;
    CustomerCallBack callBack;

    public CustomerRecvAdapter(List<CustomerVO> list, Context context, CustomerCallBack callBack) {
        this.list = list;
        this.context = context;
        this.callBack = callBack;
    }

    @NonNull
    @Override
    public CustomerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecvCustomerBinding binding = ItemRecvCustomerBinding.inflate(LayoutInflater.from(context), parent, false);
        return new CustomerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerViewHolder h, int i) {
        h.binding.customerId.setText(list.get(i).getCustomer_id() + "");
        h.binding.name.setText(list.get(i).getName());
        h.binding.gender.setText(list.get(i).getGender());
        h.binding.email.setText(list.get(i).getEmail());
        h.binding.phone.setText(list.get(i).getPhone());

        h.binding.btnDelete.setOnClickListener(v -> {
            new CommonConn(context, "delete.cu")
                    .addParamMap("customer_id", list.get(i).getCustomer_id())
                    .onExcute((isResult, data) -> {
                        callBack.onResult();
                    });
        });
        h.binding.btnUpdate.setOnClickListener(v -> {
            CustomerDialog dialog = new CustomerDialog(context, list.get(i));
            WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
            int dpi = context.getResources().getDisplayMetrics().densityDpi;
            params.width = 2*dpi;
            params.height = WindowManager.LayoutParams.WRAP_CONTENT;
            dialog.getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
            dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                @Override
                public void onDismiss(DialogInterface dialog) {
                    callBack.onResult();
                }
            });
            dialog.show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CustomerViewHolder extends RecyclerView.ViewHolder {
        ItemRecvCustomerBinding binding;

        public CustomerViewHolder(@NonNull ItemRecvCustomerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
    public interface CustomerCallBack{
        public void onResult();
    }
}
