package ru.chentsov.otushw.testingsystem.projectwork.priceinwords;

import java.util.Scanner;

public class ConsoleIO implements IO {
    Scanner scanner = new Scanner(System.in);

    /**
     * @return возвращает int переменную равную цене товара полученную из консоли
     */
    @Override
    public int getIntPrice() {
        int price;
        while (true) {
            System.out.println("Введите положительное число, равное цене товара менее 1 миллиарда");
            String inputString = scanner.nextLine();
            try {
                price = parsePrice(inputString);
            } catch (NumberFormatException nfe) {
                continue;
            }
            break;
        }
        return price;
    }

    public int parsePrice(String rawString) throws NumberFormatException {
        int price = Integer.parseInt(rawString);
        if (price <= 0 || price >= 1_000_000_000) {
            throw new NumberFormatException();
        }
        return price;
    }

    /**
     * Используется для вывода в консоль цены товара прописью
     */
    @Override
    public void outputStringPrice(String priceString) {
        System.out.println(priceString);
    }
}
