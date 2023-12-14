package com.example.and00_middletoand.middle;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {

    public static Retrofit getApiClient(){
        Retrofit retrofit = new Retrofit.Builder()//레트로핏 빌더로 레트로핏 객체 생성
                .baseUrl("http://192.168.0.57/mid/")//요청을 전송할 url을 지정. 내 톰캣 프로젝트
                .addConverterFactory(ScalarsConverterFactory.create())//String Json 사용이 가능해진다.
                .build();

        return retrofit;
    }
}
