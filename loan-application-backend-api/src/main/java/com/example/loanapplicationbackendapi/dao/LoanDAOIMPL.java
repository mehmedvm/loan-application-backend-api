package com.example.loanapplicationbackendapi.dao;


import com.example.loanapplicationbackendapi.entity.Loan;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class LoanDAOIMPL implements LoanDAO{

    //Define field for entity manager
    /*The EntityManager API is used to create and remove persistent entity instances,
        to find entities by their primary key, and to query over entities. */
    private final EntityManager entityManager;

    //Set up constructor injection
    @Autowired
    public LoanDAOIMPL(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public List<Loan> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Loan> myQuery = currentSession.createQuery("from Loan");
        return myQuery.getResultList();
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public Loan findById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Loan.class, theId);
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void saveOrUpdate(Loan theLoan) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theLoan);
    }

    @Override
    @Transactional //Defines the scope of a single database transaction.
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Loan myLoan = currentSession.get(Loan.class, theId);
        currentSession.delete(myLoan);
    }




}
