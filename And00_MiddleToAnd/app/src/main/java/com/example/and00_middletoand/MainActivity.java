package com.example.and00_middletoand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.and00_middletoand.middle.ApiClient;
import com.example.and00_middletoand.middle.ApiInterface;
import com.example.and00_middletoand.middle.MiddleVO;
import com.google.gson.Gson;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiInterface service = ApiClient.getApiClient().create(ApiInterface.class);
        MiddleVO vo = new MiddleVO("cd",100,false);

        String jsonData = new Gson().toJson(vo);

        HashMap<String, Object> params = new HashMap<>();
        params.put("andParam", jsonData);

        service.getData("aaa.and", params).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                //응답이 있는 경우
                Log.d("레트로핏", "onResponse: "+ response.body());
                Log.d("레트로핏", "onResponse: "+ response.errorBody());//잘 안쓴다.

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                //응답이 없는 경우
                Log.d("레트로핏", "onFailure: "+ t.getMessage());
                Log.d("레트로핏", "onFailure: "+ t.toString());
            }
        });

    }
}