package com.infoshareacademy.czerwoni.users.repository;

import org.jboss.security.auth.spi.Users;
import org.wildfly.security.authz.Roles;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AuthorizedUsersRepository {
    @PersistenceContext(unitName = "pUnit")
    EntityManager entityManager;

    public void addAuthorizedUser(Users users, Roles roles){
        entityManager.persist(users);
        entityManager.persist(roles);
    }
}
