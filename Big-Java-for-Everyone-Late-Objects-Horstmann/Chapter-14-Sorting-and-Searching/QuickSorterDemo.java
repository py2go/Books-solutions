package chapter14;

import java.util.Scanner;

public class QuickSorterDemo {
    public static void main(String[] args) {
        Scanner consoleIn = new Scanner(System.in);
        System.out.print("Smallest sample:");
        int smallestSample = consoleIn.nextInt();
        System.out.print("Largest sample:");
        int largestSample = consoleIn.nextInt();
        consoleIn.close();
        System.out.println(generateCharts(smallestSample, largestSample));
    }

    /**
     * Time the algorithm and return milliseconds.
     * 
     * @param array
     * @param stopwatch
     * @return
     */
    public static long timeSorting(int[] array, StopWatch stopwatch) {
        stopwatch.start();
        QuickSorter.sort(array);
        stopwatch.stop();
        return stopwatch.getElapsedTime();
    }

    public static String generateCharts(int smallestSample, int largestSample) {
        int[][] arrays = ArrayUtils.generateSampleArrays(smallestSample, largestSample);
        StringBuilder result = new StringBuilder("n - milliseconds\n");

        StopWatch stopwatch = new StopWatch();
        for (int[] array : arrays) {
            long timedSorting = timeSorting(array, stopwatch);
            stopwatch.reset();
            result.append(String.format("%s - %dms\n", array.length, timedSorting));
        }
        return result.toString();
    }
}
