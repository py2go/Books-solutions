package chapter14;

import java.util.Arrays;

public class BinaryInsertionSorter {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int next = array[i];
            int pos = modifiedBinarySearch(array, next, 0, i - 1);
            for (int j = i; j > pos; j--) {
                array[j] = array[j - 1];
            }
            array[pos] = next;
        }
    }

    public static void main(String[] args) {
        int[] array = { 15, 20, -5, 45, -33, 5, 4, 10, 11, 2, 7 };
        sort(array);
        System.out.println(Arrays.toString(array));
    }

    private static int modifiedBinarySearch(int[] array, int needle, int from, int to) {
        while (from <= to) {
            int mid = (from + to) / 2;
            if (array[mid] == needle) {
                return mid;
            } else if (array[mid] < needle) {
                from = mid + 1;
            } else {
                to = mid - 1;
            }
        }
        return from;
    }
}
