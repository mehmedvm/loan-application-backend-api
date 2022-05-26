package com.example.loanapplicationbackendapi.dao;

import com.example.loanapplicationbackendapi.entity.Loan;

import java.util.List;

public interface LoanDAO {
    List<Loan> findAll();
    Loan findById(int theId);
    void saveOrUpdate(Loan theLoan);
    void deleteById(int theId);

}
