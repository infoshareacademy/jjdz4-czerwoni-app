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

    public List<Roles> getAllRoles(){
        return entityManager.createNamedQuery("getAllRoles").getResultList();
    }
}
