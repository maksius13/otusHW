package ru.chentsov.otushw.testingsystem.projectwork.priceinwords;

public class PriceInWords {
    public static void main(String[] args) {
        IO io = new ConsoleIO();
        Countable millionsCountable = new Countable("миллион ", "миллиона ", "миллионов ", true);
        Countable thousandsCountable = new Countable("тысяча ", "тысячи ", "тысяч ", false);
        Countable currencyCountable = new Countable("рубль", "рубля", "рублей", true);
        Handler handler = new Handler(currencyCountable, thousandsCountable, millionsCountable);
        while (true) {
            int priceInt = io.getIntPrice();
            String resultString = handler.transform(priceInt);
            io.outputStringPrice(resultString);
        }
    }
}
