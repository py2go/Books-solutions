package chapter14;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class DuplicateRemover {
    // with auxiliary array
    public static int[] removeDuplicates(int[] array) {
        int[] output = new int[array.length];
        int addPos = 0;
        for (int i = 0; i < array.length; i++) {
            boolean hasDuplicate = false;
            int j = i + 1;
            while (!hasDuplicate && j < array.length) {
                if (array[i] == array[j]) {
                    hasDuplicate = true;
                }
                j += 1;
            }
            if (!hasDuplicate) {
                output[addPos] = array[i];
                addPos++;
            }
        }
        System.out.println(Arrays.toString(output));
        return output;
    }

    public static int[] removeDuplicatesWithoutAuxiliaryArrays(int[] array) {
        int arraySize = array.length;
        for (int i = 0; i < arraySize - 1; i++) {
            for (int j = i + 1; j < arraySize; j++) {
                if (array[i] == array[j]) {
                    // shift over the repetitive elements
                    for (int r = j; r < arraySize - 1; r++) {
                        array[r] = array[r + 1];
                    }
                    arraySize--;
                    j--;
                }
            }
        }
        // return array trimmed to reduced size
        return Arrays.copyOfRange(array, 0, arraySize);
    }

    public static int[] removeDuplicatesWithCollection(int[] array) {
        Set<Integer> set = new LinkedHashSet<Integer>();
        for (int element : array) {
            set.add(element);
        }
        array = new int[set.size()];
        int i = 0;
        for (Integer integer : set) {
            array[i] = integer;
            i++;
        }
        return array;
    }
}