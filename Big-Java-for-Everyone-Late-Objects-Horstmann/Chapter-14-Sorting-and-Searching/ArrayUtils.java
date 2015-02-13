package chapter14;

import java.util.Random;

public class ArrayUtils {
    private static Random generator = new Random();

    public static int[] randomIntArray(int length, int nLimit) {
        int[] output = new int[length];
        for (int i = 0; i < output.length; i++) {
            output[i] = generator.nextInt(nLimit);
        }
        return output;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static int[][] generateSampleArrays(int smallest, int largest) {
        if (smallest >= largest) {
            throw new IllegalArgumentException("Largest must be greater than smallest. Neither equal nor lesser.");
        }
        int samplesCount = Integer.parseInt(Integer.toString((largest - smallest)).substring(0, 1)) + 1;
        int[][] arrays = new int[samplesCount][];
        int sampleSize = 0;
        for (int i = 0; i < arrays.length; i++) {
            sampleSize += smallest;
            arrays[i] = ArrayUtils.randomIntArray(sampleSize, 100);
        }
        return arrays;
    }
}
