package com.infoshareacademy.czerwoni.users.ejb;

import com.infoshareacademy.czerwoni.users.domain.*;

import javax.ejb.Local;
import java.util.List;
import java.util.Set;

@Local
public interface AuthorizedUsersServiceLocal {

    void addAuthorizedUser(Users users, Roles roles);
    String getHexPassword(String password);
    Set<String> getRolesNameList();
    List<Users> getAllUsers();
    boolean isEmailUserExist(String email);
    void updateAuthorizedUser(Users users, Roles roles);
    Users getUserByEmail(String email);
    Roles getRolesByLogin(String login);
}
