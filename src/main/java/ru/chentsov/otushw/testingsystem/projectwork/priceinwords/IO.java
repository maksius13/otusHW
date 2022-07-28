package ru.chentsov.otushw.testingsystem.projectwork.priceinwords;

public interface IO {
    /**
     * @return возвращает int переменную равную цене товара
     */
    int getIntPrice();

    /**
     * Используется для вывода цены товара прописью
     */
    void outputStringPrice(String priceString);
}
