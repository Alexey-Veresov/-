package ru.p11505.edu35.practic2024.course3.creditcalculator.model;

import java.util.ArrayList;
import java.util.List;

public class EqualPayment extends AbstractPaymentPlan {

    private Credit credit;

        public EqualPayment(Credit credit) {
           super(credit);
           this.credit = credit;
        }

    @Override
    public double getOverpayment() {
        double totalPaid = getTotalPayment();
        return totalPaid - credit.getLoanAmount();
    }

    @Override
    public double getTotalPayment() {
        List<Double> schedule = getPaymentSchedule();
        return schedule.stream().mapToDouble(Double::doubleValue).sum();
    }

    @Override
    public List<Double> getPaymentSchedule() {
        List<Double> schedule = new ArrayList<>();
        int months = credit.getLoanTermMonths(); // Срок кредита уже в месяцах.
        double monthlyPrincipalPayment = credit.getLoanAmount() / months;

        for (int i = 0; i < months; i++) {
            double remainingPrincipal = credit.getLoanAmount() - monthlyPrincipalPayment * i;
            double monthlyInterestPayment = remainingPrincipal * (credit.getAnnualInterestRate() / 12 / 100);
            schedule.add(monthlyPrincipalPayment + monthlyInterestPayment);
        }
        return schedule;
    }

    @Override
    public List<CreditPayment> getCreditPaymentList() {
        List<CreditPayment> creditPayments = new ArrayList<>();
        List<Double> schedule = getPaymentSchedule(); 
        for (int i = 0; i < schedule.size(); i++) {
            creditPayments.add(new CreditPayment(schedule.get(i), i + 1));
        }
                return creditPayments;
    }
}

    

