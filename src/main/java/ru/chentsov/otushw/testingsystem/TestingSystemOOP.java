package ru.chentsov.otushw.testingsystem;

import java.util.*;

class Question {
    private String questionText;
    private String[] possibleAnswers;
    private String correctAnswer;

    /**
     * @param questionText    Текст вопроса
     * @param possibleAnswers Массив строк возможных ответов
     * @param correctAnswer   Строка с правильным ответом
     * @throws NoSuchElementException В списке возможных вариантов ответа нет указанного правильного ответа
     */
    Question(String questionText, String[] possibleAnswers, String correctAnswer) {
        if (Arrays.stream(possibleAnswers).anyMatch(s -> s.equals(correctAnswer))) {
            this.questionText = questionText;
            this.possibleAnswers = possibleAnswers;
            this.correctAnswer = correctAnswer;
        } else {
            throw new NoSuchElementException("В списке возможных вариантов ответа нет указанного правильного ответа");
        }
    }

    /**
     * Выводит в консоль вопрос и пронумерованные перемешанные случайным образом варианты ответа
     *
     * @return номер правильного ответа
     */
    int print() {
        System.out.println(this.questionText);
        List<String> newPossibleAnswers = Arrays.asList(this.possibleAnswers);
        Collections.shuffle(newPossibleAnswers);
        for (int i = 0; i < newPossibleAnswers.size(); i++) {
            System.out.printf("%d.\t%s\n", i + 1, newPossibleAnswers.get(i));
        }
        return newPossibleAnswers.indexOf(this.correctAnswer) + 1;
    }
}

class Quiz {
    Scanner scanner = new Scanner(System.in);
    private int correctly = 0, wrong = 0;
    private Question[] questions;

    /**
     * @param questions Все объекты вопросов через запятую
     */
    Quiz(Question... questions) {
        this.questions = questions;
    }

    /**
     * Запускает прохождение тестирования
     */
    void start() {
        for (Question question : questions) {
            int correctAnswerInt = question.print();

            int userAnswer = -1;
            while (userAnswer == -1) {
                try {
                    userAnswer = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Введите число с номером правильного ответа");
                    scanner.nextLine();
                }
            }
            if (correctAnswerInt == userAnswer) {
                System.out.println("Правильно");
                this.correctly++;
            } else {
                System.out.println("Неправильно");
                this.wrong++;
            }
        }
    }

    /**
     * Выводит в консоль результаты тестирования
     */
    void printResult() {
        System.out.printf("Результат: паравильно %d, неправильно %d\n", this.correctly, this.wrong);
    }

    /**
     * Сбрасывает результаты тестирования, чдля повторного прохождения
     */
    void resetResult() {
        this.correctly = 0;
        this.wrong = 0;
    }
}

public class TestingSystemOOP {
    public static void main(String[] args) throws NoSuchElementException {
        Question question1 = new Question(
                "В файл с каким расширением компилируется java-файл?",
                new String[]{"cs", "java", "class", "exe"},
                "class");
        Question question2 = new Question(
                "С помощью какой команды git можно получить полную копию удаленного репозитория?",
                new String[]{"commit", "push", "clone", "copy"},
                "clone");
        Question question3 = new Question(
                "Какой предпочтительнее применять цикл, когда не известно количество итераций?",
                new String[]{"while", "for", "loop"},
                "while");
        Quiz quiz = new Quiz(question1, question2, question3);
        quiz.start();
        quiz.printResult();
        quiz.resetResult();
        quiz.printResult();
    }
}
