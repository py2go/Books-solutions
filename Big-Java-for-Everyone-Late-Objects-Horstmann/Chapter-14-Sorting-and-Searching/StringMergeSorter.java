package chapter14;

import java.util.Arrays;

public class StringMergeSorter {
    public static void sort(String[] array) {
        if (array.length <= 1) {
            return;
        }
        String[] first = Arrays.copyOfRange(array, 0, array.length / 2);
        String[] second = Arrays.copyOfRange(array, first.length, array.length);
        sort(first);
        sort(second);
        merge(first, second, array);
    }

    private static void merge(String[] first, String[] second, String[] array) {
        int nextFirst = 0;
        int nextSecond = 0;
        int nextMerged = 0;

        while (nextFirst < first.length || nextSecond < second.length) {
            if (nextFirst >= first.length) {
                array[nextMerged] = second[nextSecond];
                nextSecond++;
            } else if (nextSecond >= second.length) {
                array[nextMerged] = first[nextFirst];
                nextFirst++;
            } else {
                String firstElement = first[nextFirst];
                String secondElement = second[nextSecond];
                int comparision = firstElement.compareTo(secondElement);
                if (comparision < 0) {
                    array[nextMerged] = firstElement;
                    nextFirst++;
                } else {
                    array[nextMerged] = secondElement;
                    nextSecond++;
                }
            }
            nextMerged++;
        }
    }
}
