package com.example.exam00_middletoand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.exam00_middletoand.common.CommonConn;
import com.example.exam00_middletoand.common.CommonRetroClient;
import com.example.exam00_middletoand.common.CommonService;
import com.example.exam00_middletoand.common.CDVO;
import com.google.gson.Gson;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CommonConn(this,"cd.cd").addParamMap("param","CD").onExcute(new CommonConn.CdCallBack() {
            @Override
            public void onResult(boolean isResult, String data) {
                Log.d("Common", "onResult: "+data);
                Log.d("Common", "onResult: "+isResult);
            }
        });


    }
}