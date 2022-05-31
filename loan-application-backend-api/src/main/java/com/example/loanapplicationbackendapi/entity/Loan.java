package com.example.loanapplicationbackendapi.entity;


import javax.persistence.*;

//Loan Entity
@Entity //This will let Java know that this is an entity that we are going to map to a database table.
@Table(name = "loan01") //This is for the actual name of the database table we are mapping to the class.
public class Loan {

    //Define fields
    @Id //This will map the primary key.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //This will auto increment your primary key
    @Column(name = "id") //This is mapping the primary key to the id column in the table.
    private int id;

    @Column(name = "applicant_name") //This will map the applicantName field to the column named applicant_name in the table.
    private String applicantName;

    @Column(name = "phone_no") //This will map the phoneNo field to the column named phone_no in the table.
    private String phoneNo;

    @Column(name = "address") //This will map the address field to the column named address in the table.
    private String address;

    @Column(name = "email") //This will map the email field to the column named email in the table.
    private String email;

    @Column(name = "credit_score") //This will map the creditScore field to the column named credit_score in the table.
    private int creditScore;

    @Column(name = "loan_number") //This will map the loanNumber field to the column named loan_number in the table.
    private int loanNumber;

    @Column(name = "interest_rate") //This will map the interestRate field to the column named interest_rate in the table.
    private float interestRate;

    //default constructor
    public Loan() {
    }

    //para constructor
    public Loan(int id, String applicantName, String phoneNo, String address, String email, int creditScore, int loanNumber, float interestRate) {
        this.id = id;
        this.applicantName = applicantName;
        this.phoneNo = phoneNo;
        this.address = address;
        this.email = email;
        this.creditScore = creditScore;
        this.loanNumber = loanNumber;
        this.interestRate = interestRate;
    }

    //getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getApplicantName() {
        return applicantName;
    }

    public void setApplicantName(String applicantName) {
        this.applicantName = applicantName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCreditScore() {
        return creditScore;
    }

    // Once the credit score is entered, the interest rate is determined as below;
    // if score > 700, the rate is 3% / if score <= 700, the rate is 4%
    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
        if (this.creditScore > 700) {
            this.interestRate = 3.00f;
        } else {
            this.interestRate = 4.00f;
        }
    }

    public int getLoanNumber() {
        return loanNumber;
    }

    public void setLoanNumber(int loanNumber) {
        this.loanNumber = loanNumber;
    }

    public float getInterestRate() {
        return interestRate;
    }

//    public void setInterestRate(float interestRate) {
//        //this.interestRate = interestRate;
//    }

    //ToString Method
    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", applicantName='" + applicantName + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", creditScore=" + creditScore +
                ", loanNumber=" + loanNumber +
                ", interestRate=" + interestRate +
                '}';
    }

}
