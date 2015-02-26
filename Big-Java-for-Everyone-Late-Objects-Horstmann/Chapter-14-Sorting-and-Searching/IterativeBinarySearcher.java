package chapter14;

public class IterativeBinarySearcher {
    public static int search(int[] array, int needle) {
        return search(array, needle, 0, array.length - 1);
    }

    public static int search(int[] array, int needle, int from, int to) {
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
        return -(from + 1);
    }
}
