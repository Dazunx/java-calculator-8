package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Separator {
    private String formula;
    List<String> defaultSeparators = List.of(",", ";");

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
            formula = formula.substring(4);
        }
        return customSeparator;
    }
    public List<String> separateDefaultSeparator(String formula){
        List<String> numlist = new ArrayList<>();

        int commaCount = formula.length() - formula.replace(defaultSeparators.get(0), "").length();
        int colonCount = formula.length() - formula.replace(defaultSeparators.get(1), "").length();

        if (commaCount>=1 && colonCount>=1){
            String[] splitByComma = formula.split(defaultSeparators.get(0));
            for (String comma : splitByComma) {
                if (comma.contains(defaultSeparators.get(1))) {
                    numlist.addAll(Arrays.asList(comma.split(defaultSeparators.get(1))));
                } else {
                    numlist.add(comma);
                }
            }
            return numlist;
        } else if (commaCount>=1) {
            return Arrays.asList(formula.split(defaultSeparators.get(0)));
        } else {
            return Arrays.asList(formula.split(defaultSeparators.get(1)));
        }
    }
    public List<String> separate(String formula){
        this.formula = formula;
        String customSeparator = setSeparator();
        List<String> separatedList = new ArrayList<>();
        List<String> allSeparatedList = new ArrayList<>();

        // separate using custom or default separator
        if (!customSeparator.isEmpty()){
            separatedList = Arrays.asList(this.formula.split(customSeparator));
            if (formula.contains(defaultSeparators.get(0)) || formula.contains(defaultSeparators.get(1))){
                for (String s:separatedList){
                    allSeparatedList.addAll(separateDefaultSeparator(s));
                }
                return allSeparatedList;
            }
        } else{
            return separateDefaultSeparator(formula);
        }
        return separatedList;
    }
}