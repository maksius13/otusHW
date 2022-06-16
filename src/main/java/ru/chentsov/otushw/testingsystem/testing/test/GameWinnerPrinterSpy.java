package ru.chentsov.otushw.testingsystem.testing.test;

import ru.chentsov.otushw.testingsystem.testing.game.GameWinnerPrinter;
import ru.chentsov.otushw.testingsystem.testing.game.Player;

import java.util.List;

public class GameWinnerPrinterSpy implements GameWinnerPrinter {
    List<String> output;

    public GameWinnerPrinterSpy(List<String> output) {
        this.output = output;
    }

    @Override
    public void printWinner(Player winner) {
        this.output.add(winner.getName());
    }
}
