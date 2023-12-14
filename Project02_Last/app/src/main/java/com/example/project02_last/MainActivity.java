package com.example.project02_last;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.util.Log;

import com.example.project02_last.common.CommonConn;
import com.example.project02_last.customer.CustomerFragment;
import com.example.project02_last.databinding.ActivityMainBinding;

import me.ibrahimsn.lib.OnItemSelectedListener;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomBar.setOnItemSelectedListener(this);

        onItemSelect(0);

    }
    public void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(binding.container.getId(), fragment).commit();
    }

    @Override
    public boolean onItemSelect(int i) {
        Log.d("btm", "onItemSelect: "+i);
        if(i==0){
            changeFragment(new CustomerFragment());
        }

        return false;
    }
}