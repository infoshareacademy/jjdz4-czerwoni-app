package com.infoshareacademy.czerwoni.users.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

public class ApiStats {


    @JsonIgnore
    private int id;
    @JsonIgnore
    private String userName;
    private String userLogin;
    private LocalDateTime loginTime;
    @JsonIgnore
    private Integer visitCount;
    @JsonIgnore
    private String lastVisit;

    public ApiStats() {
    }

    public ApiStats(String userLogin, String userName, Integer visitCount, String lastVisit) {
        this.userLogin = userLogin;
        this.userName = userName;
        this.visitCount = visitCount;
        this.lastVisit = lastVisit;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    public String getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(String lastVisit) {
        this.lastVisit = lastVisit;
    }
}
