package com.example.and10_fragmentadapter.melon;

public class MelonDTO {
    private String name, artist;
    private int musicImgRes;

    public int getMusicImgRes() {
        return musicImgRes;
    }

    public MelonDTO(String name, String artist, int musicImgRes) {
        this.name = name;
        this.artist = artist;
        this.musicImgRes = musicImgRes;
    }

    public void setMusicImgRes(int musicImgRes) {
        this.musicImgRes = musicImgRes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
