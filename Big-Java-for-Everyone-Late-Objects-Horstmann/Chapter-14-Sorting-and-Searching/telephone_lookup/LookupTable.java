package chapter14.telephone_lookup;

import java.util.Arrays;
import java.util.Scanner;

// This is easily implementable by a HashMap, but it would ruin the fun.
public class LookupTable {
    private static char NAME_SEPARATOR = ',';
    private static int DEFAULT_BUFFER_SIZE = 20;
    private String[] names;
    private String[] numbers;
    private int size;
    private boolean isSorted;

    public LookupTable() {
        this.size = 0;
        this.isSorted = true;
        this.names = new String[DEFAULT_BUFFER_SIZE];
        this.numbers = new String[DEFAULT_BUFFER_SIZE];
    }

    public void growBuffersIfNeccessary() {
        // Both buffers have the same size, no need to check both
        if (this.size == this.names.length) {
            this.growBuffer(this.names);
            this.growBuffer(this.numbers);
        }
    }

    private String[] growBuffer(String[] buffer) {
        String[] newBuffer = new String[buffer.length * 2];
        for (int i = 0; i < buffer.length; i++) {
            newBuffer[i] = buffer[i];
        }
        return newBuffer;
    }

    public void read(Scanner in) {
        boolean hasNames = false;
        String currentNames = "";
        while (in.hasNextLine()) {
            String line = in.nextLine();
            if (this.isValidName(line)) {
                currentNames = line;
                hasNames = true;
            }
            if (hasNames && this.isValidPhoneNumber(line)) {
                this.addRecord(currentNames, line);
                currentNames = "";

            }
        }
        Arrays.sort(this.names);
        Arrays.sort(this.numbers);
    }

    private boolean isValidName(String input) {
        return input.indexOf(NAME_SEPARATOR) != -1;
    }

    private boolean isValidPhoneNumber(String input) {
        return Character.isDigit(input.charAt(0)) && Character.isDigit(input.charAt(input.length() - 1));
    }

    public void addRecord(String names, String number) {
        if (!this.isValidName(names)) {
            throw new IllegalArgumentException("Invalid names given.");
        }
        if (!this.isValidPhoneNumber(number)) {
            throw new IllegalArgumentException("Invalid phone number given.");
        }
        this.growBuffersIfNeccessary();
        this.size++;
        this.names[this.size] = names;
        this.numbers[this.size] = number;
        this.isSorted = false;
    }

    private int stringBinarySearch(String[] buffer, int low, int high, String needle) {
        while (low <= high) {
            int mid = (low + high) / 2;
            int compareResult = buffer[mid].compareTo(needle);
            if (compareResult < 0) {
                low = mid + 1;
            } else if (compareResult > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -(low + 1);
    }

    private int stringBinarySearch(String[] buffer, String needle) {
        return this.stringBinarySearch(buffer, 0, buffer.length - 1, needle);
    }

    private String _lookup(String[] buffer, String needle) {
        if (!isSorted) {
            Arrays.sort(buffer);
            this.isSorted = true;
        }
        int pos = this.stringBinarySearch(buffer, needle);
        if (pos < 0) {
            return null;
        }
        return buffer[pos];
    }

    public String lookup(String names) {
        return this._lookup(this.names, names);
    }

    public String reverseLookup(String number) {
        return this._lookup(this.numbers, number);
    }
}
