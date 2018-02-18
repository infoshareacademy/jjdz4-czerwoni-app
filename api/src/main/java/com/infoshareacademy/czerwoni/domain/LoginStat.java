package com.infoshareacademy.czerwoni.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

@Entity
@NamedQueries({
        @NamedQuery(name = "getAll", query = "from LoginStat")
})

public class LoginStat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    @JsonIgnore
    private int id;
    private String userLogin;
    private LocalDateTime loginTime;

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

}
