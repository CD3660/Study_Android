package com.example.project01_cdtalk.friend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_cdtalk.R;
import com.example.project01_cdtalk.databinding.FragmentFriendBinding;

import java.util.ArrayList;


public class FriendFragment extends Fragment {
    FragmentFriendBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFriendBinding.inflate(inflater, container, false);

        binding.recvFriend.setAdapter(new FriendRecvAdapter(inflater, getFriendList(), getContext()));
        binding.recvFriend.setLayoutManager(new LinearLayoutManager(getContext()));
        return binding.getRoot();
    }

    public ArrayList<FriendDTO> getFriendList(){
        ArrayList<FriendDTO> list = new ArrayList<>();
        {
            list.add(new FriendDTO(R.drawable.profile0, R.drawable.profilebg0, "김이름", "자바"));
            list.add(new FriendDTO(R.drawable.profile1, R.drawable.profilebg1, "이민준", "오라클"));
            list.add(new FriendDTO(R.drawable.profile2, R.drawable.profilebg2, "김서준", "sql"));
            list.add(new FriendDTO(R.drawable.profile3, R.drawable.profilebg3, "강도윤", "html"));
            list.add(new FriendDTO(R.drawable.profile4, R.drawable.profilebg4, "이예준", "css"));
            list.add(new FriendDTO(R.drawable.profile5, R.drawable.profilebg5, "박지호", "자바스크립트"));
            list.add(new FriendDTO(R.drawable.profile6, R.drawable.profilebg6, "김시우", "jquery"));
            list.add(new FriendDTO(R.drawable.profile7, R.drawable.profilebg7, "장지호", "안드로이드"));
            list.add(new FriendDTO(R.drawable.profile8, R.drawable.profilebg8, "황하준", "jsp"));
            list.add(new FriendDTO(R.drawable.profile9, R.drawable.profilebg9, "배준우", ""));

            list.add(new FriendDTO(R.drawable.profile0, R.drawable.profilebg0, "김이름", "자바"));
            list.add(new FriendDTO(R.drawable.profile1, R.drawable.profilebg1, "이민준", "오라클"));
            list.add(new FriendDTO(R.drawable.profile2, R.drawable.profilebg2, "김서준", "sql"));
            list.add(new FriendDTO(R.drawable.profile3, R.drawable.profilebg3, "강도윤", "html"));
            list.add(new FriendDTO(R.drawable.profile4, R.drawable.profilebg4, "이예준", "css"));
            list.add(new FriendDTO(R.drawable.profile5, R.drawable.profilebg5, "박지호", "자바스크립트"));
            list.add(new FriendDTO(R.drawable.profile6, R.drawable.profilebg6, "김시우", "jquery"));
            list.add(new FriendDTO(R.drawable.profile7, R.drawable.profilebg7, "장지호", "안드로이드"));
            list.add(new FriendDTO(R.drawable.profile8, R.drawable.profilebg8, "황하준", "jsp"));
            list.add(new FriendDTO(R.drawable.profile9, R.drawable.profilebg9, "배준우", ""));
            binding.tvFriendCount.setText("친구"+list.size());
        }
        return list;
    }
}