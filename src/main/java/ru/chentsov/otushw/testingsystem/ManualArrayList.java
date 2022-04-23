package ru.chentsov.otushw.testingsystem;

import java.util.Arrays;

public class ManualArrayList {

    private static String[] append(String[] old_array, String new_value) {
        String[] new_array = new String[old_array.length + 1];
        for (int i = 0; i < old_array.length; i++) {
            new_array[i] = old_array[i];
        }
        new_array[old_array.length] = new_value;
        return new_array;
    }

    private static void print(String[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    private static String[] pop(String[] old_array, int index) {
        String[] new_array = new String[old_array.length - 1];
        for (int i = 0, j = 0; i < new_array.length; i++, j++) {
            if (j == index) {
                j++;
            }
            new_array[i] = old_array[j];
        }
        return new_array;
    }

    private static String[] pop(String[] old_array) {
        String[] new_array = new String[old_array.length - 1];
        for (int i = 0; i < new_array.length; i++) {
            new_array[i] = old_array[i];
        }
        return new_array;
    }

    public static void main(String[] args) {
        String[] my_array = {"text1", "text2", "text3"}; // Изначальный массив
        String[] my_array2 = append(my_array, "text4"); // Добавляем в конец строку text4
        String[] my_array3 = pop(my_array2, 2); // Удаляем элемент с индексом 2
        String[] my_array4 = pop(my_array3); // Удаляем последний элемент массива
        System.out.printf("Изначальный массив: %s\n", Arrays.toString(my_array));
        System.out.printf("Массив после добавления элемента: %s\n", Arrays.toString(my_array2));
        System.out.printf("Массив после удаления элемента: %s\n", Arrays.toString(my_array3));
        System.out.printf("Массив после удаления последнего элемента: %s\n", Arrays.toString(my_array4));
        System.out.println("Вывод массива строк:");
        print(my_array4);

//      Изначальный массив: [text1, text2, text3]
//      Массив после добавления элемента: [text1, text2, text3, text4]
//      Массив после удаления элемента: [text1, text2, text4]
//      Массив после удаления последнего элемента: [text1, text2]
//      Вывод массива строк:
//      text1
//      text2
    }
}
