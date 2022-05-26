package com.example.loanapplicationbackendapi.controller;


import com.example.loanapplicationbackendapi.entity.Loan;
import com.example.loanapplicationbackendapi.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//This is to allow calls from React... NOT IMPORTANT RIGHT NOW
@CrossOrigin(origins = { "http://localhost:3000"})
@RestController
public class LoanController {
    private final LoanService loanService;

    //Constructor Injection: this is telling the spring framework to wire up your
    //dependencies for the loanService.
    @Autowired
    public LoanController(@Qualifier("loanServiceIMPL")LoanService loanService) {
        this.loanService = loanService;
    }

    //This is a GET request that will read a list of all the employees.
    //http://localhost:8080/retrieveAllLoans
    @GetMapping("/retrieveAllLoans")
    public List<Loan> findAll() {
        return loanService.findAll();
    }

    //MM - This is a GET request that will retrieve a loan based on the id.
    //http://localhost:8080/retrieveLoan/2
    @GetMapping("/retrieveLoan/{loanId}")
    public Object retrieveLoan(@PathVariable int loanId) {
        //This will execute the findByID.
        Object myLoan = loanService.findById(loanId);
        return "The requested loan:\n" +myLoan; //
    }


    //This is a POST request to add a new employee.
    //http://localhost:8080/addLoan
    @PostMapping("/addLoan")
    public Loan addLoan(@RequestBody Loan theLoan) {
        //also, just in case they pass an id in JSON .... set id to 0
        //this is to force a save of new item .... instead of update
        theLoan.setId(0);

        //This will call the loanDqoImpl.save method to save a new loan
        //through the employeeService
        loanService.saveOrUpdate(theLoan);
        return theLoan;//return the Loan makes the added loan show in the Postman results window
    }

    //This is a PUT request to update an existing loan.
    //http://localhost:8080/updateLoan
    @PutMapping("/updateLoan")
    public Loan updateLoan(@RequestBody Loan updateLoan) {
        //Notice theLoan.setId(0); this will execute an update instead of a create
        loanService.saveOrUpdate(updateLoan);
        return updateLoan;
    }

    //This is a DELETE request to delete an existing loan.
    //http://localhost:8080/deleteLoan/1
    @DeleteMapping("/deleteLoan/{loanId}")
    public String deleteLoan(@PathVariable int loanId) {
        //This will execute the deleteByID.
        loanService.deleteById(loanId);
        return "Deleted loan id : " + loanId;
    }



}
