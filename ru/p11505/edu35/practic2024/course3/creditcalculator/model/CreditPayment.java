package ru.p11505.edu35.practic2024.course3.creditcalculator.model;

import java.util.Date;

public class CreditPayment {
    private Date paymentDate; 
    private double amount; 

    public CreditPayment(Date paymentDate, double amount) {
        this.paymentDate = paymentDate;
        this.amount = amount;
    }

    public CreditPayment(Double amount, int month) {
        this.amount = (amount != null) ? amount : 0.0;
        this.paymentDate = new Date();
    }
    public Date getPaymentDate() {
        return paymentDate;
    }

    public double getAmount() {
        return amount;
    }

  
    @Override
    public String toString() {
        return String.format("Дата платежа: %s, Сумма платежа: %.2f", paymentDate.toString(), amount);
    }
}
