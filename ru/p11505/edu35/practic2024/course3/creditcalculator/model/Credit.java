package ru.p11505.edu35.practic2024.course3.creditcalculator.model;

import java.util.Date;

public class Credit { 
    private double loanAmount; 
    private double annualInterestRate; 
    private int loanTermMonths; 
    private Date startDate;
    private String user;
            
     public Credit(String user, double loanAmount, double annualInterestRate, int loanTermMonths, Date startDate) { 
            this.user = user; 
            this.loanAmount = loanAmount; 
            this.annualInterestRate = annualInterestRate; 
            this.loanTermMonths = loanTermMonths; 
            this.startDate = new Date(System.currentTimeMillis()); 
        } 
    
        public Date getStartDate() { 
            return startDate; 
        } 
    
        public String getUser() { 
            return user; 
        } 
    
        public double getLoanAmount() { 
            return loanAmount; 
        } 
    
        public double getAnnualInterestRate() { 
            return annualInterestRate; 
        } 
    
        public int getLoanTermMonths() { 
            return loanTermMonths; 
        }

        public void setUser(String user) {
            this.user = user;
        }

        public void setLoanAmount(double loanAmount) {
            this.loanAmount = loanAmount;
        }

        public void setAnnualInterestRate(double annualInterestRate) {
            this.annualInterestRate = annualInterestRate;
        }

        public void setLoanTermMonths(int loanTermMonths) {
            this.loanTermMonths = loanTermMonths;
        }

        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }
}