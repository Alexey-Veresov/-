package ru.p11505.edu35.practic2024.course3.creditcalculator.model;

import java.util.List;

public abstract class AbstractPaymentPlan {
    @Deprecated
    public final double loanAmount;
    @Deprecated
    protected final double annualInterestRate;
    @Deprecated
    protected final int loanTermMonths;

    public AbstractPaymentPlan(Credit credit) {
        this.loanAmount = credit.getLoanAmount();
        this.annualInterestRate = credit.getAnnualInterestRate();
        this.loanTermMonths = credit.getLoanTermMonths();
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

    public double getOverpayment() {
        double totalPaid = getTotalPayment();
        return totalPaid - loanAmount;
    }

    public abstract double getTotalPayment();
    public abstract List<CreditPayment> getCreditPaymentList();
    public abstract List<Double> getPaymentSchedule();
}
 