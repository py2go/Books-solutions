package chapter14;

public class MaxSubArraySumFinder {
    // naive O(n^2)
    public static int findSubArraySumNaive(int[] array) {
        int maxSumStartIndex = 0;
        int maxSumEndIndex = 0;

        int maxSum = array[0];
        for (int i = 0; i < array.length; i++) {
            int currentSum = array[i];
            int currentSumEndIndex = 0;
            for (int j = i + 1; j < array.length; j++) {
                if (currentSum + array[j] < currentSum) {
                    break;
                }
                currentSum += array[j];
                currentSumEndIndex = j;
            }
            if (currentSum > maxSum) {
                maxSumStartIndex = i;
                maxSumEndIndex = currentSumEndIndex;
                maxSum = currentSum;
            }
        }
        System.out.println(String.format("Max Sum from %d to %d", maxSumStartIndex, maxSumEndIndex));
        return maxSum;
    }

    // optimal O(n)
    public static int findSubArraySum(int[] array) {
        int maxSum = array[0];
        int maxSumStartIndex = 0;
        int maxSumEndIndex = 0;

        int currentSum = array[0];
        int currentSumStartIndex = 0;

        for (int i = 1; i < array.length; i++) {
            currentSum += array[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxSumStartIndex = currentSumStartIndex;
                maxSumEndIndex = i;
            } else if (currentSum < maxSum) {
                currentSumStartIndex = i;
                currentSum = array[i];
            }
        }
        System.out.println(String.format("Max Sum from %d to %d", maxSumStartIndex, maxSumEndIndex));
        return maxSum;
    }
}
