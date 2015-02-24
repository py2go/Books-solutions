package chapter14.telephone_lookup;

import java.util.LinkedList;
import java.util.Scanner;

public class LinkedLookupTable {
    private static char NAME_SEPARATOR = ',';
    private LinkedList<String> names;
    private LinkedList<String> numbers;

    public LinkedLookupTable() {
        this.names = new LinkedList<String>();
        this.numbers = new LinkedList<String>();
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
    }

    public String lookup(String names) {
        int pos = this.names.indexOf(names);
        if (pos == -1) {
            return null;
        }
        return this.numbers.get(pos);
    }

    public String reverseLookup(String number) {
        int pos = this.numbers.indexOf(number);
        if (pos == -1) {
            return null;
        }
        return this.names.get(pos);
    }
}
