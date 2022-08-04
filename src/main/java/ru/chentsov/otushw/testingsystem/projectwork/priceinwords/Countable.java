package ru.chentsov.otushw.testingsystem.projectwork.priceinwords;

public class Countable {
    private final String singular;
    private final String some;
    private final String plural;
    boolean masculine;

    public Countable(String singular, String some, String plural, boolean masculine) {
        this.singular = singular;
        this.some = some;
        this.plural = plural;
        this.masculine = masculine;
    }

    public boolean isMasculine() {
        return masculine;
    }

    public String print(int number) {
        int significantValue = number % 100;
        if (significantValue % 10 == 1 && significantValue != 11) {
            return this.singular;
        }
        if (significantValue % 10 >= 2 && significantValue % 10 <= 4 & (significantValue < 12 || significantValue > 14)) {
            return this.some;
        }
        return this.plural;
    }
}
