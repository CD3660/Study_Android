package com.example.and00_middletoand.middle;

public class MiddleVO {
    private String str;
    private int num;
    private boolean bool;

    public MiddleVO(String str, int num, boolean bool) {
        this.str = str;
        this.num = num;
        this.bool = bool;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isBool() {
        return bool;
    }

    public void setBool(boolean bool) {
        this.bool = bool;
    }
}
