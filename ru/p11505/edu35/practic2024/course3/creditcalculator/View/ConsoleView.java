package ru.p11505.edu35.practic2024.course3.creditcalculator.View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import ru.p11505.edu35.practic2024.course3.creditcalculator.model.Credit;
import ru.p11505.edu35.practic2024.course3.creditcalculator.model.EqualPayment;
import ru.p11505.edu35.practic2024.course3.creditcalculator.model.PaymentSchedule;
 
public class ConsoleView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
         final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        
        // Ввод данных о кредите
        System.out.println("Введите ФИО клиента:");
        String user = scanner.nextLine();

        System.out.println("Введите сумму кредита:");
        double loanAmount = scanner.nextDouble();

        System.out.println("Введите годовую процентную ставку:");
        double annualInterestRate = scanner.nextDouble();

        System.out.println("Введите срок кредита в годах:");
        int loanTermMonths = scanner.nextInt();

        // Ввод даты начала кредита
        Date startDate = null;
        while (startDate == null) {
            System.out.println("Введите дату начала кредита (дд-ММ-гггг):");
            String inputDate = scanner.next();
            try {
                startDate = dateFormatter.parse(inputDate);
            } catch (ParseException e) {
                System.out.println("Неверный формат даты. Пожалуйста, введите дату в формате дд-ММ-гггг.");
            }
        } 
        
        Credit credit = new Credit(user, loanAmount, annualInterestRate, loanTermMonths, startDate);
        EqualPayment paymentPlan = new EqualPayment(credit);
        System.out.printf("Общая сумма выплат равными платежами: %.2f\n", paymentPlan.getTotalPayment());
        System.out.printf("Переплата: %.2f\n", paymentPlan.getOverpayment());
        System.out.println("Введите сумму досрочного погашения (0, если нет):");
        double earlyRepaymentAmount = scanner.nextDouble();

if (earlyRepaymentAmount > 0) {  

    Date repaymentDate = null;  
    while (repaymentDate == null) {  
        System.out.println("Введите дату досрочного погашения (дд-ММ-гггг):");  
        String inputRepaymentDate = scanner.next();  
        try {  
            repaymentDate = dateFormatter.parse(inputRepaymentDate);  
            if (repaymentDate.before(startDate)) {  
                System.out.println("Дата досрочного погашения не может быть ранее даты начала кредита.");  
                repaymentDate = null; 
            }  
        } catch (ParseException e) {  
            System.out.println("Неверный формат даты. Пожалуйста, введите дату в формате дд-ММ-гггг.");  
        }  
    }  
 
    PaymentSchedule paymentSchedule = new PaymentSchedule(); 
    paymentSchedule.createPaymentSchedule(credit, repaymentDate, earlyRepaymentAmount);
}
    scanner.close();
    }
}

