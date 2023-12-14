package com.example.project02_last.member;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.project02_last.MainActivity;
import com.example.project02_last.R;
import com.example.project02_last.common.CommonConn;
import com.example.project02_last.databinding.ActivityLoginBinding;
import com.google.gson.Gson;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.user.UserApiClient;
import com.navercorp.nid.NaverIdLoginSDK;
import com.navercorp.nid.oauth.NidOAuthLogin;
import com.navercorp.nid.oauth.OAuthLoginCallback;
import com.navercorp.nid.profile.NidProfileCallback;
import com.navercorp.nid.profile.data.NidProfileMap;
import com.navercorp.nid.profile.data.NidProfileResponse;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Glide.with(this)
                .load("https://i1.ruliweb.com/ori/17/04/23/15b9a751497159acd.gif")
                .error(R.drawable.ic_launcher_foreground)//에러 발생
                .fallback(R.drawable.ic_launcher_background)//null 반환시
                .into(binding.imgvLogo);

        NaverIdLoginSDK.INSTANCE.initialize(this, getString(  R.string.CLIENT_ID_NAVER ), getString(  R.string.CLIENT_SECRET_NAVER ), getString(  R.string.CLIENT_NAME_NAVER ));

        binding.btnLogin.setOnClickListener(v -> {
            login(binding.edtId.getText().toString(), binding.edtPw.getText().toString());
        });

        getHashKey();
        naverlogin();
        binding.imgvKakaoLogin.setOnClickListener(v -> {
            kakaoLogin();
        });

    }


    public void naverlogin() {
        binding.buttonOAuthLoginImg.setOAuthLogin(new OAuthLoginCallback() {
            @Override
            public void onSuccess() {
                Log.d("네이버", "onSuccess: " + NaverIdLoginSDK.INSTANCE.getAccessToken());


                new NidOAuthLogin().callProfileApi(new NidProfileCallback<NidProfileResponse>() {
                    @Override
                    public void onSuccess(NidProfileResponse nidProfileResponse) {
                        login(nidProfileResponse.getProfile().getEmail(), null);

                        Log.d("네이버", "onSuccess: " + nidProfileResponse.getProfile().getEmail());
                        Log.d("네이버", "onSuccess: " + nidProfileResponse.getProfile().getName());
                        Log.d("네이버", "onSuccess: " + nidProfileResponse.getProfile().getProfileImage());
                    }

                    @Override
                    public void onFailure(int i, @NonNull String s) {

                    }

                    @Override
                    public void onError(int i, @NonNull String s) {

                    }
                });

            }

            @Override
            public void onFailure(int i, @NonNull String s) {
                Log.d("네이버", "onFailure: ");
            }

            @Override
            public void onError(int i, @NonNull String s) {
                Log.d("네이버", "onError: ");
            }
        });
    }

    private void getHashKey() {
        PackageInfo packageInfo = null;
        try {
            packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageInfo == null)
            Log.e("KeyHash", "KeyHash:null");

        for (Signature signature : packageInfo.signatures) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.d("KeyHash", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            } catch (NoSuchAlgorithmException e) {
                Log.e("KeyHash", "Unable to get MessageDigest. signature=" + signature, e);
            }
        }
    }

    public void kakaoLogin() {

        //        KakaoSdk.init(this, "{NATIVE_APP_KEY}")
        KakaoSdk.init(this, getString(R.string.NATIVE_APP_KEY));
        Function2<OAuthToken, Throwable, Unit> callback = new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable error) {
                if (error == null) {
                    Log.d("카카오", "invoke: " + oAuthToken.getAccessToken());
                } else {
                    Log.d("카카오", "invoke: " + error.getMessage());
                }

                return null;
            }
        };
        //카카오톡 설치여부 확인 true->앱으로 인증(권장)
//                           false->웹뷰로 인증
        if (UserApiClient.getInstance().isKakaoTalkLoginAvailable(this)) {
            Log.d("카카오", "kakaoLogin: 카카오톡 설치됨->app");
            UserApiClient.getInstance().loginWithKakaoTalk(this, callback);

        } else {
            Log.d("카카오", "kakaoLogin: 카카오톡 설치 안됨->web");
            UserApiClient.getInstance().loginWithKakaoAccount(this, callback);
            UserApiClient.getInstance().me((user, throwable) -> {
                if (throwable == null) {
                    Log.d("카카오정보", "invoke: " + user.getKakaoAccount().getProfile().getNickname());
                    Log.d("카카오정보", "invoke: " + user.getKakaoAccount().getProfile().getProfileImageUrl());
                } else {
                    Log.d("카카오정보", "invoke: " + throwable.getMessage());
                }
                return null;
            });
        }


    }

    public void login(String user_id, String user_pw) {
        CommonConn conn = new CommonConn(this, "login.me")
                .addParamMap("user_id", user_id);
        if (user_pw == null) {
            conn.addParamMap("social", "y");
        } else {
            conn.addParamMap("user_pw", user_pw);
        }
        conn.onExcute((isResult, data) -> {
            MemberVO vo = new Gson().fromJson(data, MemberVO.class);
            if (vo == null) {
                Toast.makeText(this, "아이디 또는 패스워드 틀림", Toast.LENGTH_SHORT).show();
                return;
            }
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        });
    }
}