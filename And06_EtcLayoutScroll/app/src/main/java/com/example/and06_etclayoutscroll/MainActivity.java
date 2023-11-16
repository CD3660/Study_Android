package com.example.and06_etclayoutscroll;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv_text;
    ScrollView scroll_v;
    HorizontalScrollView scroll_h;
    View btm_nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_text = findViewById(R.id.tv_text);
        btm_nav = findViewById(R.id.btm_nav);
        scroll_h = findViewById(R.id.scroll_h);
        scroll_v = findViewById(R.id.scroll_v);

        btm_nav.setOnClickListener(v ->{
            Log.d("Scroll위치", "getScrollY: "+ scroll_v.getScrollY());
            Log.d("Scroll위치", "getScrollX: "+ scroll_h.getScrollX());
            scroll_v.scrollTo(0,scroll_v.getScrollY()+100);
            scroll_h.smoothScrollTo(scroll_h.getScrollX()+100, 0);
        });

        tv_text.setText("");

        for(int i =0; i<100; i++){
            for(int j=0; j<8; j++) {
                tv_text.append("안녕하세요 ");
            }
            tv_text.append("안녕하세요 \n");
        }
    }
}