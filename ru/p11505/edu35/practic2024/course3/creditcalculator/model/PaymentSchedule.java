package ru.p11505.edu35.practic2024.course3.creditcalculator.model;

import java.text.SimpleDateFormat; 
import java.util.Calendar; 
import java.util.Date; 
import java.util.List; 

public class PaymentSchedule { 
     
    public void createPaymentSchedule(Credit creditCalculator, Date repaymentDate, double earlyRepaymentAmount) { 
        List<Double> newPayments = EarlyRepaymentCalculator.calculateNewPayments(creditCalculator, earlyRepaymentAmount, repaymentDate); 
         
        Calendar paymentDate = Calendar.getInstance(); 
        paymentDate.setTime(creditCalculator.getStartDate()); 
        paymentDate.add(Calendar.MONTH, 1);  

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); 
         
        System.out.println("График платежей:"); 

        for (int i = 0; i < newPayments.size(); i++) { 
            System.out.printf("Платеж %d: %s - %.2f\n", i + 1, dateFormat.format(paymentDate.getTime()), newPayments.get(i)); 
            paymentDate.add(Calendar.MONTH, 1);
        } 
    } 

    public static void main(String[] args) { 
        Date currentDate = new Date(System.currentTimeMillis()); 
        System.out.println("Текущая дата: " + new SimpleDateFormat("dd-MM-yyyy").format(currentDate)); 
    } 

    @Override 
    public String toString() { 
        return "PaymentSchedule []"; 
    } 
}
