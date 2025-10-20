package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultSeparator implements Separator {
    List<String> separator = List.of(",", ";");

    public List<String> extractSeparator(String formula) {
        if (formula.contains(separator.get(0)) || formula.contains(separator.get(1))){
            return separator;
        } else {
            return null;
        }
    }
    public List<String> separate(String formula, List<String> separator) {
        List<String> numlist = new ArrayList<>();
        int commaCount = formula.length() - formula.replace(separator.get(0), "").length();
        int colonCount = formula.length() - formula.replace(separator.get(1), "").length();

        if (commaCount >= 1 && colonCount >= 1) {
            String[] splitByComma = formula.split(separator.get(0));
            for (String comma : splitByComma) {
                if (comma.contains(separator.get(1))) {
                    numlist.addAll(Arrays.asList(comma.split(separator.get(1))));
                } else {
                    numlist.add(comma);
                }
            }
            return numlist;
        } else if (commaCount >= 1) {
            return Arrays.asList(formula.split(separator.get(0)));
        } else {
            return Arrays.asList(formula.split(separator.get(1)));
        }
    }
}