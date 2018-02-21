package com.infoshareacademy.czerwoni.repository;

import com.infoshareacademy.czerwoni.domain.LoginStat;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class LoginStatsRepository {

    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;

    public boolean addStat(LoginStat loginStat) {
        entityManager.persist(loginStat);
        return true;
    }

    public List<LoginStat> getStatList() {
        return (List<LoginStat>) entityManager.createNamedQuery("getAll")
                .getResultList();
    }

}
