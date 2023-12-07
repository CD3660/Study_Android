package com.example.project01_cdtalk.chat;

public class ChatDTO {
    private String name, lastChat, lastUpdate;
    private int imgSrc;

    public ChatDTO(String name, String lastChat, String lastUpdate, int imgSrc) {
        this.name = name;
        this.lastChat = lastChat;
        this.lastUpdate = lastUpdate;
        this.imgSrc = imgSrc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastChat() {
        return lastChat;
    }

    public void setLastChat(String lastChat) {
        this.lastChat = lastChat;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public int getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(int imgSrc) {
        this.imgSrc = imgSrc;
    }
}
