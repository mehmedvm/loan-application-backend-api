package com.example.loanapplicationbackendapi.service;

import com.example.loanapplicationbackendapi.dao.LoanDAO;
import com.example.loanapplicationbackendapi.entity.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceIMPL implements LoanService {
    // Injecting the loan dao layer
    private final LoanDAO loanDAO;

    @Autowired
    public LoanServiceIMPL(LoanDAO loanDAO) {
        this.loanDAO = loanDAO;
    }

    @Override
    public List<Loan> findAll() {
        return loanDAO.findAll();
    }

    @Override
    public Object findById(int loanId) {
        return loanDAO.findById(loanId);
    }

    @Override
    public void saveOrUpdate(Loan theLoan) {
        loanDAO.saveOrUpdate(theLoan);
    }

    @Override
    public void deleteById(int loanId) {
        loanDAO.deleteById(loanId);
    }



}
