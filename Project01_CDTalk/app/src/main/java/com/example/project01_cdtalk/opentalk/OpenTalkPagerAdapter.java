package com.example.project01_cdtalk.opentalk;

import android.view.LayoutInflater;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class OpenTalkPagerAdapter extends FragmentStateAdapter {
    LayoutInflater inflater;
    ArrayList<Fragment> list;

    public OpenTalkPagerAdapter(@NonNull Fragment fragment, ArrayList<Fragment> list) {
        super(fragment);
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int i) {
        return list.get(i);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
