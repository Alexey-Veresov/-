package ru.p11505.edu35.practic2024.course3.creditcalculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Date;

public class AnnuityPaymentPlan extends AbstractPaymentPlan {
    private Credit credit;

    public AnnuityPaymentPlan(Credit credit) {
        super(credit);
     }


    @Override
    public double getTotalPayment() {
        List<Double> schedule = getPaymentSchedule();
        double total = 0.0;
        for (double payment : schedule) {
            total += payment;
        }
        return total;
    }

    @Override
    public List<Double> getPaymentSchedule() {
        List<Double> schedule = new ArrayList<>();
        int months = credit.getLoanTermMonths(); 
        double monthlyInterestRate = credit.getAnnualInterestRate() / 12 / 100;
        double annuityCoefficient = (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, months)) /
                (Math.pow(1 + monthlyInterestRate, months) - 1);
        double monthlyPayment = credit.getLoanAmount() * annuityCoefficient;

        for (int i = 0; i < months; i++) {
            schedule.add(monthlyPayment);
        }
        return schedule;
    }

    @Override 
public List<CreditPayment> getCreditPaymentList() { 
    List<CreditPayment> creditPayments = new ArrayList<>(); 
    List<Double> paymentSchedule = getPaymentSchedule(); 
    
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(new Date()); 

    for (double payment : paymentSchedule) { 
        creditPayments.add(new CreditPayment(calendar.getTime(), payment)); 
        calendar.add(Calendar.MONTH, 1); 
    } 
    return creditPayments; 
}
}

