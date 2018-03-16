package com.infoshareacademy.czerwoni.users.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "getAllUsers", query = "from Users"),
        @NamedQuery(name = "getUserByEmail", query = "from Users where email=:email"),
        @NamedQuery(name = "getEmailByLogin", query = "select email from Users where login=:login"),
        @NamedQuery(name = "getUserByLogin", query = "from Users where login=:login")
})
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int userId;
    @Column(nullable = false)
    private String login;
    @Column(nullable = false)
    private String password;
    @Column
    private String name;
    @Column
    private String surname;
    @Column(unique = true, nullable = false)
    private String email;

    public Users() {
    }

    public Users(String login, String password, String name, String surname, String email) {
        this.login = login;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (userId != users.userId) return false;
        if (login != null ? !login.equals(users.login) : users.login != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        if (name != null ? !name.equals(users.name) : users.name != null) return false;
        if (surname != null ? !surname.equals(users.surname) : users.surname != null) return false;
        return email != null ? email.equals(users.email) : users.email == null;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}