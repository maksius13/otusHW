package ru.chentsov.otushw.testingsystem.projectwork.priceinwords;

public class PriceInWords {
    public static void main(String[] args) {
        IO io = new ConsoleIO();
        while (true) {
            int priceInt = io.getIntPrice();
            String resultString = Handler.transform(priceInt);
            io.outputStringPrice(resultString);
        }
    }
}
