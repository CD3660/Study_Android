package com.example.and08_activity_intent;

import java.io.Serializable;

public class LoginDTO implements Serializable {
    private String loginId, loginPw;

    public LoginDTO(String loginId, String loginPw) {
        this.loginId = loginId;
        this.loginPw = loginPw;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public String getLoginPw() {
        return loginPw;
    }

    public void setLoginPw(String loginPw) {
        this.loginPw = loginPw;
    }
}
