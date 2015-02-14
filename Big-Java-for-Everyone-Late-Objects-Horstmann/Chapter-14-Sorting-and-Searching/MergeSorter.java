package chapter14;

import java.util.Arrays;

public class MergeSorter {
    public static int mergeSum(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        int[] first = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] second = Arrays.copyOfRange(array, first.length, array.length);
        int sumFirst = mergeSum(first);
        int sumSecond = mergeSum(second);
        return sumFirst + sumSecond;
    }

    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int[] first = new int[array.length / 2];
        int[] second = new int[array.length - first.length];

        for (int i = 0; i < first.length; i++) {
            first[i] = array[i];
        }
        for (int i = 0; i < second.length; i++) {
            second[i] = array[i + first.length];
        }

        mergeSort(first);
        mergeSort(second);
        merge(first, second, array);
    }

    public static void sort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        int[] first = new int[array.length / 2];
        int[] second = new int[array.length - first.length];

        for (int i = 0; i < first.length; i++) {
            first[i] = array[i];
        }

        for (int i = 0; i < second.length; i++) {
            second[i] = array[first.length + i];
        }
        sort(first);
        sort(second);
        merge(first, second, array);
    }

    private static void merge(int[] first, int[] second, int[] array) {
        int nextFirst = 0;
        int nextSecond = 0;
        int nextArray = 0;
        while (nextFirst < first.length && nextSecond < second.length) {
            if (first[nextFirst] < second[nextSecond]) {
                array[nextArray] = first[nextFirst];
                nextFirst += 1;
            } else {
                array[nextArray] = second[nextSecond];
                nextSecond += 1;
            }
            nextArray += 1;
        }
        while (nextFirst < first.length) {
            array[nextArray] = first[nextFirst];
            nextFirst += 1;
            nextArray += 1;
        }
        while (nextSecond < second.length) {
            array[nextArray] = second[nextSecond];
            nextSecond += 1;
            nextArray += 1;
        }
    }
}
