package chapter14;

public class IterativeMergeSorter {
    public static void sort(int[] array) {
        int[] temp = new int[array.length];

        for (int blockSize = 1; blockSize < array.length; blockSize *= 2) {
            for (int i = 0; i < array.length - blockSize; i += blockSize * 2) {
                int from = i;
                int middle = blockSize + i;
                int to = Math.min(2 * blockSize + i, array.length) - 1;
                merge(array, temp, from, middle, to);
            }
        }
    }

    private static void merge(int[] array, int[] buffer, int from, int middle, int to) {
        int i = from;
        int j = middle;

        for (int nextMerged = 0; nextMerged <= to - from; nextMerged++) {
            if (i < middle && (j > to || array[i] <= array[j])) {
                buffer[nextMerged] = array[i];
                i++;
            } else {
                buffer[nextMerged] = array[j];
                j++;
            }
        }

        for (int k = from; k <= to; k++) {
            array[k] = buffer[k - from];
        }
    }
}
