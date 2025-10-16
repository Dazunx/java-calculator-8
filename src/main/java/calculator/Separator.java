package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Separator {
    private String formula;

    public String setSeparator() {
        String customSeparator = "";
        formula = formula.replace("\\n", "\n");

        int frontCount = (formula.length() - formula.replace("//", "").length())/2;
        int backCount = formula.length() - formula.replace("\n", "").length();

        // extract custom separator
        if (frontCount>=1 && backCount==1){
            String[] array = formula.split("\n");
            customSeparator = array[0].substring(2);
            formula = array[1];
        } else if (frontCount==1 && backCount>1) { // if custom separator is "\n"
            customSeparator = "\n";
            formula = formula.substring(6);
        }
        return customSeparator;
    }
    public List<String> separateDefaultSeparator(List<String> numlist){
        List<String> defaultSeparators = List.of(",", ";");
        int commaCount = this.formula.length() - this.formula.replace(defaultSeparators.get(0), "").length();
        int colonCount = this.formula.length() - this.formula.replace(defaultSeparators.get(1), "").length();

        if (commaCount>=1 && colonCount>=1){
            String[] splitByComma = this.formula.split(defaultSeparators.get(0));
            for (String comma : splitByComma) {
                if (comma.contains(defaultSeparators.get(1))) {
                    String[] splitByColon = comma.split(defaultSeparators.get(1));
                    List<String> colonList = Arrays.asList(splitByColon);
                    numlist.addAll(colonList);
                } else {
                    numlist.add(comma);
                }
            }
        } else if (commaCount>=1) {
            String[] numbers = this.formula.split(defaultSeparators.getFirst());
            numlist = Arrays.asList(numbers);
        } else if (colonCount>=1) {
            String[] numbers = this.formula.split(defaultSeparators.get(1));
            numlist = Arrays.asList(numbers);
        }
        return numlist;
    }
    public List<String> separate(String formula){
        this.formula = formula;
        String[] numbers;
        List<String> numlist = new ArrayList<>();
        String customSeparator = setSeparator();

        // separate using custom separator
        if (!customSeparator.isEmpty()){
            numbers = this.formula.split(customSeparator);
            numlist = Arrays.asList(numbers);
        }
        // separate using default separator
        else {
            numlist = separateDefaultSeparator(numlist);
        }
        return numlist;
    }
}