package hu.nive.ujratervezes.zarovizsga.digitscounter;

import java.util.HashSet;
import java.util.Set;

public class DigitsCounter {


    public int getCountOfDigits(String s) {
        if (isEmpty(s)) {
            return 0;
        }
        Set<String> uniqueNumbers = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                uniqueNumbers.add(s.substring(i, i + 1));
            }
        }

        return uniqueNumbers.size();
    }

    private boolean isEmpty(String s) {
        return s == null || s.isBlank();
    }
}
