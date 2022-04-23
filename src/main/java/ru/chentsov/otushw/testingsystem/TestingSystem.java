package ru.chentsov.otushw.testingsystem;

import java.util.Scanner;

public class TestingSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int correctly = 0, wrong = 0;
        String[][][] quiz = { // Задавать в формате {{Вопрос}, {Номер правильного ответа (начиная с 1) строкой}, {Варианты ответов через запятую строками}}
                {
                        {"В файл с каким расширением компилируется java-файл?"},
                        {"3"},
                        {"cs", "java", "class", "exe"}
                },
                {
                        {"С помощью какой команды git можно получить полную копию удаленного репозитория?"},
                        {"3"},
                        {"commit", "push", "clone", "copy"}
                },
                {
                        {"Какой предпочтительнее применять цикл, когда не известно количество итераций?"},
                        {"1"},
                        {"while", "for", "loop"}
                }
        };
        for (String[][] tour : quiz) {
            System.out.println(tour[0][0]);
            for (int i = 0; i < tour[2].length; i++) {
                System.out.printf("%d.\t%s\n", i + 1, tour[2][i]);
            }
            String user_answer = scanner.nextLine();
            if (user_answer.equals(tour[1][0])) {
                System.out.println("Правильно");
                correctly++;
            } else {
                System.out.println("Неправильно");
                wrong++;
            }
        }
        System.out.printf("Результат: паравильно %d, неправильно %d", correctly, wrong);
    }
}
