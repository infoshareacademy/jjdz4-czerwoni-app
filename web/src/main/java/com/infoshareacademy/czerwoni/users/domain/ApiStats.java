package com.infoshareacademy.czerwoni.users.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

public class ApiStats {


    @JsonIgnore
    private int id;
    private String userLogin;
    private LocalDateTime loginTime;

    public ApiStats() {
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }


    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

}
