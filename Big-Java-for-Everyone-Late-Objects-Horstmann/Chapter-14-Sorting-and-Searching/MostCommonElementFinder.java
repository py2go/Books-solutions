package chapter14;


public class MostCommonElementFinder {
    // Naive O(n^2)
    public static int findMostCommonNaive(int[] array) {
        int[] frequencies = new int[array.length];
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) {
                    frequencies[i]++;
                }
            }
        }
        int mostCommonIndex = 0;
        int maxFrequency = array[0];
        for (int i = 1; i < frequencies.length; i++) {
            if (maxFrequency < frequencies[i]) {
                mostCommonIndex = i;
                maxFrequency = array[i];
            }
        }

        return array[mostCommonIndex];
    }

    // Optimal O(N logN)
    public static int findMostCommonOptimal(int[] array) {
        QuickSorter.sort(array);
        int mostCommonFrequency = 0;
        int currentFrequency = 0;
        int mostCommonIndex = 0;
        for (int i = 0; i < array.length; i++) {
            currentFrequency++;
            if (i == array.length - 1 || array[i] != array[i + 1]) {
                if (currentFrequency > mostCommonFrequency) {
                    mostCommonFrequency = currentFrequency;
                    mostCommonIndex = i;
                }
                currentFrequency = 0;
            }
        }
        return array[mostCommonIndex];
    }
}
