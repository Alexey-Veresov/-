package ru.p11505.edu35.practic2024.course3.creditcalculator.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calendar {
    private SimpleDateFormat dateFormatter;

    public Calendar(String pattern) {
        this.dateFormatter = new SimpleDateFormat(pattern);
    }

    public Date parse(String dateString) {
        try {
            return dateFormatter.parse(dateString);
        } catch (ParseException e) {
            System.out.println("Неверный формат даты. Пожалуйста, введите дату в формате " + dateFormatter.toPattern() + ".");
            return null;
        }
    }


    public String format(Date date) {
        return dateFormatter.format(date);
    }
}
