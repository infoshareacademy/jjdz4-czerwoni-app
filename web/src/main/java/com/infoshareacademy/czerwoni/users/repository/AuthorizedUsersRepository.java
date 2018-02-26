package com.infoshareacademy.czerwoni.users.repository;

import com.infoshareacademy.czerwoni.users.domain.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

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
}
