package chapter6;

import java.util.Arrays;

/*Write a method public static void removeMin that removes the minimum value from a
 partially filled array without calling other methods.*/

public class P6_05 {
    public static int[] removeMin(int[] seq) {
        int minIndex = 0;
        for (int i = 1; i < seq.length; i++) {
            if (seq[i] < seq[minIndex]) {
                minIndex = i;
            }
        }
        return Arrays.copyOfRange(seq, minIndex + 1, seq.length);
    }
}
