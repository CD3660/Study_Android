package com.example.and08_activity_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {
    Button btn_login;
    EditText edt_id, edt_pw;
    TextView tv_join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_login = findViewById(R.id.btn_login);
        edt_id = findViewById(R.id.edt_id);
        edt_pw = findViewById(R.id.edt_pw);
        btn_login.setOnClickListener(v -> {
            String id = edt_id.getText().toString();
            String pw = edt_pw.getText().toString();
            if("admin".equals(id)&&"admin1234".equals(pw)){
                Log.d("로그인 성공", id);
                LoginDTO dto = new LoginDTO(id,pw);
                ArrayList<LoginDTO> list = new ArrayList<>();
                list.add(new LoginDTO("id1", "pw1"));
                list.add(new LoginDTO("id2", "pw2"));


                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("strkey", "테스트데이터 스트링");
                intent.putExtra("intkey", 111);
                intent.putExtra("dtokey",dto);
                intent.putExtra("listkey", list);




                startActivity(intent);
                finish();
            } else {
                Log.d("로그인 실패", id);
            }
        });
        tv_join = findViewById(R.id.tv_join);
        tv_join.setOnClickListener(v->{
            Intent intent = new Intent(LoginActivity.this, JoinActivity.class);
            startActivity(intent);
        });
    }


}