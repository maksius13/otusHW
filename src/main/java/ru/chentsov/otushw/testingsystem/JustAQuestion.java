package ru.chentsov.otushw.testingsystem;

public class JustAQuestion {
    public static void main(String[] args) {
        Date date1 = new Date();
        Date date2 = new Date("2022-05-01");
        System.out.println(date1.getDay());
        System.out.println(date2.getDay());
        System.out.println(Date.getDay());
    }
}

class Date {
    int day;
    int month;
    int year;

    protected Date() {
        // получить дату из системы
        this.day = dayFromSystem;
        this.month = monthFromSystem;
        this.year = yearFromsSystem;
    }

    protected Date(String dateTimeString) {
        // распарсить строку
        this.day = dayFromString;
        this.month = monthFromString;
        this.year = yearFromsString;
    }

    protected int getDay() {
        return this.day;
    }

    protected static int getDay() {
        // получить дату из системы
        return dayFromSystem;
    }
}