package com.example.loanapplicationbackendapi.service;

import com.example.loanapplicationbackendapi.entity.Loan;

import java.util.List;

public interface LoanService {
    List<Loan> findAll();  //
    Object findById(int partId);
    void saveOrUpdate(Loan theLoan);
    void deleteById(int partId);

}
