package com.example.exam00_middletoand.common;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class CommonRetroClient {

    public static Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.57/mid/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        return retrofit;
    }
}
