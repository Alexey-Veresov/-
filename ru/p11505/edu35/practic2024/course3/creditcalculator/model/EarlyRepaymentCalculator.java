package ru.p11505.edu35.practic2024.course3.creditcalculator.model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EarlyRepaymentCalculator {

    public static List<Double> calculateNewPayments(Credit creditCalculator, double earlyRepaymentAmount, Date repaymentDate) {
        List<Double> newPayments = new ArrayList<>();
        
        // Если досрочное погашение равно 0, то просто запрашиваем платежи на основе имеющегося кредита
        double remainingLoanAmount = creditCalculator.getLoanAmount();
        
        // Если сумма досрочного погашения больше, чем оставшаяся сумма, устанавливаем ее в 0
        if (earlyRepaymentAmount > remainingLoanAmount) {
            earlyRepaymentAmount = remainingLoanAmount;
        }
        
        // Рассчитываем оставшуюся сумму долга после досрочного погашения
        remainingLoanAmount -= earlyRepaymentAmount;

        // Расчет месячной процентной ставки
        double monthlyInterestRate = creditCalculator.getAnnualInterestRate() / 12 / 100;
        int originalTotalMonths = creditCalculator.getLoanTermMonths() * 12;
        int monthsPaid = monthsBetween(creditCalculator.getStartDate(), repaymentDate);

        double newMonthlyPayment = (remainingLoanAmount * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -(originalTotalMonths - monthsPaid)));

        for (int i = 0; i < monthsPaid; i++) {
            newPayments.add(newMonthlyPayment); 
        }

       
        if (earlyRepaymentAmount > 0) {
            newPayments.add(earlyRepaymentAmount); 
        }

        for (int i = monthsPaid + 1; i < originalTotalMonths; i++) {
            newPayments.add(newMonthlyPayment); 
        }

        return newPayments;
    }

    private static int monthsBetween(Date startDate, Date endDate) { 
        Calendar startCal = Calendar.getInstance(); 
        Calendar endCal = Calendar.getInstance(); 
        startCal.setTime(startDate); 
        endCal.setTime(endDate); 
    
        return (endCal.get(Calendar.YEAR) - startCal.get(Calendar.YEAR)) * 12 + 
               (endCal.get(Calendar.MONTH) - startCal.get(Calendar.MONTH));
    }
    
}
