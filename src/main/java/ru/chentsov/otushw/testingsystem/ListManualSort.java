package ru.chentsov.otushw.testingsystem;

import java.util.*;
import java.util.stream.Collectors;

public class ListManualSort {

    private static List<Integer> mergeSort(List<Integer> oldList) {
        int count = oldList.size();
        List<Integer> newList = new ArrayList<>();
        if (count > 2) {
            List<Integer> lb = mergeSort(oldList.subList(0, count / 2));
            List<Integer> rb = mergeSort(oldList.subList(count / 2, count));
            newList.addAll(lb);
            newList.addAll(rb);
            int lastIndex = newList.size() - 1;

            for (int i = 0; i < lastIndex; i++) {
                Integer mv = newList.get(i);
                int mi = i;

                for (int j = i + 1; j < lastIndex + 1; j++) {
                    if (mv > newList.get(j)) {
                        mv = newList.get(j);
                        mi = j;
                    }
                }

                if (mi != i) {
                    Integer temVar = newList.get(i);
                    newList.set(i, newList.get(mi));
                    newList.set(mi, temVar);
                }
            }
        } else if (oldList.size() > 1 && oldList.get(0) > oldList.get(1)) {
            newList.add(oldList.get(1));
            newList.add(oldList.get(0));
        } else {
            newList.addAll(oldList);
        }

        return newList;
    }

    private static List<Integer> createRandomList(int size, int maxValue) {
        Random random = new Random();
        List<Integer> integerList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            integerList.add(random.nextInt(maxValue));
        }
        return integerList;
    }


    public static void main(String[] args) {
        List<Integer> intsList = createRandomList(10_000, 1_000);
        long date1 = new Date().getTime();
        List<Integer> intsListSortedManual = mergeSort(intsList);
        long date2 = new Date().getTime();
        List<Integer> integerListSorted = intsList.stream().sorted().collect(Collectors.toList());
        long date3 = new Date().getTime();
        System.out.printf("Отсортированные списки одинаковы? %s\n", integerListSorted.equals(intsListSortedManual));
        System.out.printf("Время ручной сортировки %s ms\n", date2 - date1);
        System.out.printf("Время встроенной сортировки %s ms\n", date3 - date2);

    }
}
