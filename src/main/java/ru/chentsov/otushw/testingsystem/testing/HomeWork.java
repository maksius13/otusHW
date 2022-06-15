package ru.chentsov.otushw.testingsystem.testing;


import ru.chentsov.otushw.testingsystem.testing.game.*;
import ru.chentsov.otushw.testingsystem.testing.test.Assertions;
import ru.chentsov.otushw.testingsystem.testing.test.DiceSpy;
import ru.chentsov.otushw.testingsystem.testing.test.GameWinnerPrinterSpy;

import java.util.ArrayList;
import java.util.List;

public class HomeWork {

    /*
        Заготовка для ДЗ представляет собой игру в кости.
        При вызове game.playGame(), два игрока кидают кости.
        Выигрывает игрок, у кого результат (1-6) больше
        Написать тесты (минимум 4) на классы DiceImpl и Game.
        Тесты должны найти не менее двух ошибок.
        Информацию о пройденном тесте предлагается выводить в System.out, а об упавшем в System.err
     */
    public static void main(String[] args) {
        new TestPlayer1Win().start();
        new TestPlayer2Win().start();
        new TestDiceRoll().start();
        new TestDraw().start();
    }

}

class TestPlayer1Win {
    String scenario = "Проверка победы Васи";
    List<String> output = new ArrayList<>();
    Dice dice = new DiceSpy(5, 1);
    GameWinnerPrinter winnerPrinter = new GameWinnerPrinterSpy(output);

    void start() {
        Game game = new Game(dice, winnerPrinter);
        game.playGame(new Player("Вася"), new Player("Игорь"));
        try {
            Assertions.assertEquals("Вася", output.get(0));
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}

class TestPlayer2Win {
    String scenario = "Проверка победы Игоря";
    List<String> output = new ArrayList<>();
    Dice dice = new DiceSpy(2, 4);
    GameWinnerPrinter winnerPrinter = new GameWinnerPrinterSpy(output);

    void start() {
        Game game = new Game(dice, winnerPrinter);
        game.playGame(new Player("Вася"), new Player("Игорь"));
        try {
            Assertions.assertEquals("Игорь", output.get(0));
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}

class TestDiceRoll {
    String scenario = "Проверка, что кубики возвращают значения от 1 до 6";
    Dice dice = new DiceImpl();

    void start() {
        try {
            for (int i = 0; i < 1_000_000; i++) {
                Assertions.assertBetween(1, 6, dice.roll());
            }
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}

class TestDraw {
    String scenario = "Проверка случая ничьей";
    List<String> output = new ArrayList<>();
    List<String> ignore = List.of("Вася", "Игорь");
    Dice dice = new DiceSpy(3, 3);
    GameWinnerPrinter winnerPrinter = new GameWinnerPrinterSpy(output);

    void start() {
        Game game = new Game(dice, winnerPrinter);
        game.playGame(new Player("Вася"), new Player("Игорь"));
        try {
            Assertions.assertNotContain(output.get(0), ignore);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }


}