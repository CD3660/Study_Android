package com.example.project01_cdtalk.friend;

import com.example.project01_cdtalk.R;

import java.io.Serializable;

public class FriendDTO implements Serializable {
    private String name, msg;
    private int profileImg, subImg;

    public FriendDTO(int profileImg, int subImg ,String name, String msg) {
        this.name = name;
        this.msg = msg;
        this.profileImg = profileImg;
        this.subImg = subImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(int profileImg) {
        this.profileImg = profileImg;
    }

    public int getSubImg() {
        return subImg;
    }

    public void setSubImg(int subImg) {
        this.subImg = subImg;
    }
}
