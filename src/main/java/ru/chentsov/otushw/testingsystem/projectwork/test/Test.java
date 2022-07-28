package ru.chentsov.otushw.testingsystem.projectwork.test;

import ru.chentsov.otushw.testingsystem.projectwork.priceinwords.ConsoleIO;
import ru.chentsov.otushw.testingsystem.projectwork.priceinwords.Handler;
import ru.chentsov.otushw.testingsystem.testing.test.Assertions;


public class Test {
    public static void main(String[] args) {
        new CheckParsePriceFromConsole().start();
        new CheckTransformPriceToString().start();
    }
}

class CheckParsePriceFromConsole {
    String firstInputString = "price";
    String secondInputString = "-6";
    String thirdInputString = "237628632836";
    String fourthInputString = "5";
    ConsoleIO consoleIO = new ConsoleIO();

    void start() {
        System.out.println("Проверка правильности преобразования строки с ценой в число");
        start1();
        start2();
        start3();
        start4();
        System.out.println("Проверка правильности преобразования строки с ценой в число завершена");
    }

    private void start1() {
        String scenario = "Проверка получения ошибки, если строка не соответвует числу";
        try {
            Assertions.assertThrows(NumberFormatException.class, () -> consoleIO.parsePrice(firstInputString));
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    private void start2() {
        String scenario = "Проверка получения ошибки, если строка соответствует отрицательному числу";
        try {
            Assertions.assertThrows(NumberFormatException.class, () -> consoleIO.parsePrice(secondInputString));
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    private void start3() {
        String scenario = "Проверка получения ошибки, если строка соответствует слишком большому числу";
        try {
            Assertions.assertThrows(NumberFormatException.class, () -> consoleIO.parsePrice(thirdInputString));
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    private void start4() {
        String scenario = "Проверка получения правильного числа";
        try {
            Assertions.assertEquals(5, consoleIO.parsePrice(fourthInputString));
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}

class CheckTransformPriceToString {
    void start() {
        System.out.println("Проверка правильности преобразования цены в запись прописью");
        start1();
        start2();
        start3();
        start4();
        System.out.println("Проверка правильности преобразования цены в запись прописью завершена");
    }

    private void start1() {
        int price = 1;
        String expectedString = "один рубль";
        String scenario = "Проверка " + price;

        try {
            Assertions.assertEquals(expectedString, Handler.transform(price));
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    private void start2() {
        int price = 127;
        String expectedString = "сто двадцать семь рублей";
        String scenario = "Проверка " + price;

        try {
            Assertions.assertEquals(expectedString, Handler.transform(price));
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    private void start3() {
        int price = 735_193;
        String expectedString = "семьсот тридцать пять тысяч сто девяносто три рубля";
        String scenario = "Проверка " + price;

        try {
            Assertions.assertEquals(expectedString, Handler.transform(price));
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    private void start4() {
        int price = 1_000_000;
        String expectedString = "один миллион рублей";
        String scenario = "Проверка " + price;

        try {
            Assertions.assertEquals(expectedString, Handler.transform(price));
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}