package com.infoshareacademy.czerwoni.users.repository;

import com.infoshareacademy.czerwoni.users.domain.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class AuthorizedUsersRepository {
    @PersistenceContext(unitName = "pUnit")
    EntityManager entityManager;

    public void addAuthorizedUser(Users users, Roles roles){
        entityManager.persist(users);
        entityManager.persist(roles);
    }

    public void updateAuthorizedUser(Users users, Roles roles){
        entityManager.merge(users);
        entityManager.merge(roles);
    }

    public List<Roles> getAllRoles(){
        return entityManager.createNamedQuery("getAllRoles").getResultList();
    }

    public List<Users> getAllUsers() {
        return entityManager.createNamedQuery("getAllUsers").getResultList();
    }

    public Users getUserByEmail(String email) {
        return (Users) entityManager.createNamedQuery("getUserByEmail").setParameter("email",email).getSingleResult();
    }

    public Roles getRolesByLogin(String login) {
        return (Roles) entityManager.createNamedQuery("getRolesByLogin").setParameter("login", login).getSingleResult();
    }

    public String getEmailByLogin(String login) {
        return (String) entityManager.createNamedQuery("getEmailByLogin").setParameter("login", login).getSingleResult();
    }

    public Users getUserByLogin(String login) {
        return entityManager.createNamedQuery("getUserByLogin", Users.class)
                .setParameter("login", login)
                .getSingleResult();
    }
}
