package com.example.study_2;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.Map;

public class Task extends AsyncTask<Map<String, String>, Integer, String> {
    public static String ip = "183.xxx.xxx."; // 자신의 IP주소를 쓰시면 됩니다.
    private Context mctx; //이부분은 toast를 쓰려고 Task를 사용하는 activity의 Context를 받기위해 만들어짐.

    public Task(Context ctx) { //Context의 생성자.
        this.mctx = ctx;
    }

    @Override
    protected String doInBackground(Map<String, String>... maps) { // 내가 전송하고 싶은 파라미터
        // Http 요청 준비 작업
        HttpClient.Builder http = new HttpClient.Builder
                ("POST", "http://" + ip + "/gisAndroid.do"); //포트번호,서블릿주소
        // Parameter 를 전송한다.
        http.addAllParameters(maps[0]);
        //Http 요청 전송
        HttpClient post = http.create();
        post.request();
        // 응답 상태코드 가져오기
        int statusCode = post.getHttpStatusCode();
        // 응답 본문 가져오기
        String body = post.getBody();
        return body;
    }

    @Override
    protected void onPostExecute(String s) { //서블릿으로부터 값을 받을 함수
        Gson gson = new Gson();
        MsgVO Msg = gson.fromJson(s, MsgVO.class);
        Toast myToast = Toast.makeText(mctx, Msg.getMsg(), Toast.LENGTH_SHORT);
        myToast.show();
    }
}