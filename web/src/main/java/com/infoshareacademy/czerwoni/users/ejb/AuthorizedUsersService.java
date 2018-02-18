package com.infoshareacademy.czerwoni.users.ejb;

import com.infoshareacademy.czerwoni.users.repository.AuthorizedUsersRepository;
import org.jboss.crypto.CryptoUtil;
import com.infoshareacademy.czerwoni.users.domain.*;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.HashSet;
import java.util.Set;


@Stateless
public class AuthorizedUsersService implements AuthorizedUsersServiceLocal {

    @Inject
    AuthorizedUsersRepository authorizedUsersRepository;

    @Override
    public void addAuthorizedUser(Users users, Roles roles) {
        authorizedUsersRepository.addAuthorizedUser(users, roles);
    }

    @Override
    public String getHexPassword(String password) {
        return CryptoUtil.createPasswordHash("MD5", "hex", null, null, password);
    }

    @Override
    public Set<String> getRolesNameList(){
        Set<String> rolesSet = new HashSet<>();
        authorizedUsersRepository
                .getAllRoles()
                .forEach(roles -> rolesSet.add(roles.getUserRole()));
        return rolesSet;
    }
}
