package ru.chentsov.otushw.testingsystem.projectwork.priceinwords;

public class NumberProcessor {

    public static String transform(int number, boolean masculine) {
        String outputString = "";
        int hundreds = number / 100;
        if (hundreds > 0) {
            outputString += transformHundreds(hundreds);
        }
        if (number % 100 >= 20){
            int dozens = number % 100 / 10;
            outputString += transformDozens(dozens);
            int units = number % 100 % 10;
            if (units > 0) {
                outputString += transformUnits(units, masculine);
            }
        }
        else {
            int units = number % 100;
            if (units > 0) {
                outputString += transformUnits(units, masculine);
            }
        }
        return outputString;
    }

    private static String transformHundreds(int hundreds) {
        switch (hundreds) {
            case 1:
                return "сто ";
            case 2:
                return "двести ";
            case 3:
                return "триста ";
            case 4:
                return "четыреста ";
            case 5:
                return "пятьсот ";
            case 6:
                return "шестьсот ";
            case 7:
                return "семьсот ";
            case 8:
                return "восемьсот ";
            case 9:
                return "девятьсот ";
            default:
                throw new NumberFormatException("Сотен больше 9");
        }
    }

    private static String transformDozens(int dozens) {
        switch (dozens) {
            case 2:
                return "двадцать ";
            case 3:
                return "тридцать ";
            case 4:
                return "сорок ";
            case 5:
                return "петьдесят ";
            case 6:
                return "шестьдесят ";
            case 7:
                return "семьдесят ";
            case 8:
                return "восемьдесят ";
            case 9:
                return "девяносто ";
            default:
                throw new NumberFormatException("Десятков больше 9");
        }
    }

    private static String transformUnits(int units, boolean masculine) {
        switch (units) {
            case 1:
                return masculine ? "один " : "одна ";
            case 2:
                return masculine ? "два " : "две ";
            case 3:
                return "три ";
            case 4:
                return "четыре ";
            case 5:
                return "пять ";
            case 6:
                return "шесть ";
            case 7:
                return "семь ";
            case 8:
                return "восемь ";
            case 9:
                return "девять ";
            case 10:
                return "десять ";
            case 11:
                return "одинадцать ";
            case 12:
                return "двенадцать ";
            case 13:
                return "тринадцать ";
            case 14:
                return "четырнадцать ";
            case 15:
                return "пятнадцать ";
            case 16:
                return "шестнадцать ";
            case 17:
                return "семнадцать ";
            case 18:
                return "восемнадцать ";
            case 19:
                return "девятнадцать ";
            default:
                throw new NumberFormatException("Сотен больше 19");
        }
    }

}
