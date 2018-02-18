package com.infoshareacademy.czerwoni.domain;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

public class LoginStat {
    public LoginStat() {
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
    public LocalDateTime getLoginTime() {
        return loginTime;
    }


    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    private String userLogin;
    private LocalDateTime loginTime;
}
