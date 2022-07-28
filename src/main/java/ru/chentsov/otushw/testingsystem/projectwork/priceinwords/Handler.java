package ru.chentsov.otushw.testingsystem.projectwork.priceinwords;

public class Handler {
    public static String transform(int price) {
        String finalString = "";
        Countable millionsCountable = new Countable("миллион ", "миллиона ", "миллионов ");
        Countable thousandsCountable = new Countable("тысяча ", "тысячи ", "тысяч ");
        Countable currencyCountable = new Countable("рубль", "рубля", "рублей");
        int millions = price / 1_000_000;
        int thousands = price % 1_000_000 / 1_000;
        int units = price % 1_000_000 % 1_000;
        if (millions > 0) {
            finalString += NumberProcessor.transform(millions, true);
            finalString += millionsCountable.print(millions);
        }
        if (thousands > 0) {
            finalString += NumberProcessor.transform(thousands, false);
            finalString += thousandsCountable.print(thousands);
        }
        if (units > 0) {
            finalString += NumberProcessor.transform(units, true);
        }
        finalString += currencyCountable.print(units);
        return finalString;
    }
}
