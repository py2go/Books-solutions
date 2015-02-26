package chapter14;


public class IterativeMergeSorter {
    private static void merge(int[] array, int[] buffer, int from, int middle, int to) {
        int i = from;
        int j = middle;
        int nextMerged = from;
        while (i < middle || j < to) {
            if (i >= middle) {
                buffer[nextMerged] = array[j];
                j++;
            } else if (j >= to) {
                buffer[nextMerged] = array[i];
                i++;
            } else {
                if (array[i] < array[j]) {
                    buffer[nextMerged] = array[i];
                    i++;
                } else {
                    buffer[nextMerged] = array[j];
                    j++;
                }
            }
            nextMerged++;
        }
    }

    public static void sort(int[] array) {
        int[] temp = new int[array.length];

        for (int i = 1; i < array.length; i *= 2) {
            for (int j = 0; j < array.length; j += 2 * i) {
                int from = j;
                int middle = i + j;
                int to = 2 * i + j;
                merge(array, temp, from, middle, to);
            }
            for (int j = 0; j < array.length; j++) {
                array[j] = temp[j];
            }
        }
    }
}
