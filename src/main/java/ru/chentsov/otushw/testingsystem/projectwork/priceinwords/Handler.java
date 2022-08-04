package ru.chentsov.otushw.testingsystem.projectwork.priceinwords;

public class Handler {
    Countable millionsCountable;
    Countable thousandsCountable;
    Countable currencyCountable;

    public Handler(Countable currencyCountable, Countable thousandsCountable, Countable millionsCountable) {
        this.millionsCountable = millionsCountable;
        this.thousandsCountable = thousandsCountable;
        this.currencyCountable = currencyCountable;
    }

    public String transform(int price) {
        String finalString = "";
        int millions = price / 1_000_000;
        int thousands = price % 1_000_000 / 1_000;
        int units = price % 1_000_000 % 1_000;
        if (millions > 0) {
            finalString += NumberProcessor.transform(millions, millionsCountable.isMasculine());
            finalString += millionsCountable.print(millions);
        }
        if (thousands > 0) {
            finalString += NumberProcessor.transform(thousands, thousandsCountable.isMasculine());
            finalString += thousandsCountable.print(thousands);
        }
        if (units > 0) {
            finalString += NumberProcessor.transform(units, currencyCountable.isMasculine());
        }
        finalString += currencyCountable.print(units);
        return finalString;
    }
}
