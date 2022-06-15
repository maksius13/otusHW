package ru.chentsov.otushw.testingsystem.testing.test;

import ru.chentsov.otushw.testingsystem.testing.game.Dice;

public class DiceSpy implements Dice {
    int iteration = 0;
    int first;
    int second;

    public DiceSpy(int first, int second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public int roll() {
        if (iteration == 0){
            iteration++;
            return first;
        }
        return second;
    }
}
