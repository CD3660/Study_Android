package com.example.and00_vendingmachine;

import android.widget.Button;
import android.widget.TextView;

public class Drink {
    private TextView tv_name, tv_cnt;
    private Button btn_order;
    private int cnt, price;

    public TextView getTv_name() {
        return tv_name;
    }

    public void setTv_name(TextView tv_name) {
        this.tv_name = tv_name;
    }

    public TextView getTv_cnt() {
        return tv_cnt;
    }

    public void setTv_cnt(TextView tv_cnt) {
        this.tv_cnt = tv_cnt;
    }

    public Button getBtn_order() {
        return btn_order;
    }

    public void setBtn_order(Button btn_order) {
        this.btn_order = btn_order;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
        tv_cnt.setText(cnt + " 개 남음");
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public Drink(String name, int price, int cnt, TextView tv_name, TextView tv_cnt, Button btn_order) {
        this.tv_name = tv_name;
        this.tv_cnt = tv_cnt;
        this.btn_order = btn_order;
        this.cnt = cnt;
        this.price = price;
        this.name = name;

        tv_name.setText(name+" "+price+" 원");
        tv_cnt.setText(cnt+" 개 남음");



    }

}
