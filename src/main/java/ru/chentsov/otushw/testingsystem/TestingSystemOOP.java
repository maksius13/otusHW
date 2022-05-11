package ru.chentsov.otushw.testingsystem;

import java.util.*;

class Question {
    private final String questionText;
    private final String[] possibleAnswers;
    private final String correctAnswer;
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * @param questionText    Текст вопроса
     * @param possibleAnswers Массив строк возможных ответов
     * @param correctAnswer   Строка с правильным ответом
     * @throws NoSuchElementException В списке возможных вариантов ответа нет указанного правильного ответа
     */
    Question(String questionText, String[] possibleAnswers, String correctAnswer) {
        if (Arrays.asList(possibleAnswers).contains(correctAnswer)) {
            this.questionText = questionText;
            this.possibleAnswers = possibleAnswers;
            this.correctAnswer = correctAnswer;
        } else {
            throw new NoSuchElementException("В списке возможных вариантов ответа нет указанного правильного ответа");
        }
    }

    /**
     * Выводит в консоль вопрос
     */
    private void printQuestion() {
        System.out.println(this.questionText);
    }

    /**
     * Выводит в консоль вопрос пронумерованные варианты ответа
     *
     * @param PossibleAnswers Список возможных ответов
     */
    private void printPossibleAnswers(List<String> PossibleAnswers) {
        for (int i = 0; i < PossibleAnswers.size(); i++) {
            System.out.printf("%d.\t%s\n", i + 1, PossibleAnswers.get(i));
        }
    }

    /**
     * Метод меремешивает массив возможных ответов
     *
     * @return список перемешанных вариантов ответа
     */
    private List<String> shufflePossibleAnswers() {
        List<String> newPossibleAnswers = Arrays.asList(this.possibleAnswers);
        Collections.shuffle(newPossibleAnswers);
        return newPossibleAnswers;
    }

    /**
     * Определение в списке ответов номер правильного ответа (начиная с 1, что бы было привычно для человека)
     *
     * @param PossibleAnswers Список возможных ответов
     * @return номер правильного ответа
     */
    private int getCorrectAnswer(List<String> PossibleAnswers) {
        return PossibleAnswers.indexOf(this.correctAnswer) + 1;
    }

    /**
     * Получение ответа пользователя.
     * В случае если было введено не число, спрашивает снова
     *
     * @return выбранный пользователем номер ответа
     */
    private int getUserAnswer() {
        int userAnswer = -1;
        while (userAnswer == -1) {
            try {
                userAnswer = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введите число с номером правильного ответа");
                scanner.nextLine();
            }
        }
        return userAnswer;
    }

    /**
     * Реализует логику задавания вопроса, получения и проверки пользовательского ответа
     *
     * @return Правильность ответа пользователя
     */
    boolean askQuestionAndGetAnswer() {
        printQuestion();
        List<String> newPossibleAnswers = shufflePossibleAnswers();
        printPossibleAnswers(newPossibleAnswers);
        int correctAnswer = getCorrectAnswer(newPossibleAnswers);
        int userAnswer = getUserAnswer();
        return correctAnswer == userAnswer;
    }
}

class Quiz {
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
            boolean resultAskQuestion = question.askQuestionAndGetAnswer();
            if (resultAskQuestion) {
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
     * Сбрасывает результаты тестирования, для повторного прохождения
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
