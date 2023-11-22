package com.example.and08_activity_intent;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final String TAG = "액티비티 수명주기";
    EditText edt_phone, edt_find, edt_sms;
    Button btn_phone, btn_find, btn_sms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: ");

        Intent intent = getIntent();
        Log.d(TAG, "onCreate: "+intent.getStringExtra("strkey"));
        Log.d(TAG, "onCreate: "+intent.getIntExtra("intkey", -1));
        Log.d(TAG, "onCreate: "+intent.getIntExtra("intKey", -1));
        LoginDTO dto = (LoginDTO) intent.getSerializableExtra("dtokey");
        Log.d(TAG, "onCreate: "+dto.getLoginId());
        Log.d(TAG, "onCreate: "+dto.getLoginPw());
        ArrayList<LoginDTO> list = (ArrayList<LoginDTO>) intent.getSerializableExtra("listkey");
        Log.d(TAG, "onCreate: "+list.size());
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
        edt_phone = findViewById(R.id.edt_phone);
        edt_find = findViewById(R.id.edt_find);
        edt_sms = findViewById(R.id.edt_sms);
        btn_phone = findViewById(R.id.btn_phone);
        btn_find = findViewById(R.id.btn_find);
        btn_sms = findViewById(R.id.btn_sms);

        btn_phone.setOnClickListener(v->{
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/"+edt_phone.getText().toString()));
            startActivity(intent);
        });
        btn_find.setOnClickListener(this);
        btn_sms.setOnClickListener(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: ");
    }
    
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: ");
    }

    //추후 ActivityLauncher, onActivityResult 등으로 결과를 가져오는 코드도 진행
    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.btn_find){
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, edt_find.getText().toString());
            startActivity(intent);
        } else if(v.getId()==R.id.btn_sms){
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:"+Uri.encode("010-1234-5678")));
            intent.putExtra("sms_body", edt_sms.getText().toString());
            startActivity(intent);
        }
    }
}