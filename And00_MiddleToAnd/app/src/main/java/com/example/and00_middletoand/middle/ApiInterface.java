package com.example.and00_middletoand.middle;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Url;

public interface ApiInterface {

    //어떤 url을 요청하고 어떤 형태로 변환을 받을 것인지 파라메터 등이 지정되어있는 설계도
    //ApiInterface를 통해 레트로핏 전송객체가 초기화 된다.
    //Retrofit 어노테이션으로 @GET, @POST가 있다.
    //Form method(get or post)

    @FormUrlEncoded //@Url을 같이 사용해야만 가능하다. 어노테이션이 없는 경우 동작이 불가능하다.
    @POST
    Call<String> getData(@Url String url, @FieldMap HashMap<String, Object> params);


//    public interface GitHubService {
//        @GET("users/{user}/repos")
//        Call<List<Repo>> listRepos(@Path("user") String user);
//    }


}
