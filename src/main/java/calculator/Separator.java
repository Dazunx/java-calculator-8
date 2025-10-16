package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Separator {
    public void setSeparator(String formula) {
        String customSeparator = "";
        List<Character> defaultSeparator = List.of(',', ';');
        formula = formula.replace("\\n", "\n");

        int frontCount = (formula.length() - formula.replace("//", "").length())/2;
        int backCount = formula.length() - formula.replace("\n", "").length();

        // custom separator
        if (frontCount>=1 && backCount==1){
            String[] array = formula.split("\n");
            customSeparator = array[0].substring(2);
            formula = array[1];
        } else if (frontCount==1 && backCount>1) { // if custom separator is "\n"
            customSeparator = "\n";
            formula = formula.substring(6);
        }
    }
}
