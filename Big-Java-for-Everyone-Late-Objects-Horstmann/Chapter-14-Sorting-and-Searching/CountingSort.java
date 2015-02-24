package chapter14;

import java.util.Arrays;

public class CountingSort {
    public static int[] sort(int[] array, int low, int high) {
        int[] counts = new int[high - low + 1];
        for (int i : array) {
            counts[i - low]++;
        }
        int current = 0;
        for (int i = 0; i < counts.length; i++) {
            Arrays.fill(array, current, current + counts[i], i + low);
            current += counts[i];
        }
        return counts;
    }
}
