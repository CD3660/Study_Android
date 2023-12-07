package com.example.project01_cdtalk;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.project01_cdtalk.chat.ChatFragment;
import com.example.project01_cdtalk.databinding.ActivityMainBinding;
import com.example.project01_cdtalk.friend.FriendFragment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0f);
        actionBar.setTitle("친구");

        changeFragment(new FriendFragment());

        binding.btmNav.setOnItemSelectedListener(item -> {
            actionBar.setTitle(item.getTitle());
            if(item.getItemId() == R.id.tab1){
                changeFragment(new FriendFragment());
            }else if(item.getItemId() == R.id.tab2){
                changeFragment(new ChatFragment());
            }
            return true;
        });


    }
    public void changeFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
    }
}