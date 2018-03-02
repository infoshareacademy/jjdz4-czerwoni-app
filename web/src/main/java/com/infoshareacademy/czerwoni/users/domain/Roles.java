package com.infoshareacademy.czerwoni.users.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "roles")
@NamedQueries({
        @NamedQuery(name = "getAllRoles", query = "from Roles"),
        @NamedQuery(name = "getRolesByLogin", query = "from Roles where userLogin=:login")
})
public class Roles implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int roleId;
    @Column(name = "user_login", nullable = false)
    private String userLogin;
    @Column(name = "user_role")
    private String userRole;
    @Column(name = "role_group")
    private String userGroup;

    public Roles(){}

    public Roles(String userLogin, String userRole, String userGroup) {
        this.userLogin = userLogin;
        this.userRole = userRole;
        this.userGroup = userGroup;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(String userGroup) {
        this.userGroup = userGroup;
    }

}
