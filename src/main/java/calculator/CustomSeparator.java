package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomSeparator implements Separator {
    String formula;
    List<String> separator = new ArrayList<>();

    public List<String> extractSeparator(String formula) {
        formula = formula.replace("\\n", "\n");

        int frontCount = (formula.length() - formula.replace("//", "").length())/2;
        int backCount = formula.length() - formula.replace("\n", "").length();

        if (frontCount>=1 && backCount==1){
            String[] array = formula.split("\n");
            separator.add(array[0].substring(2));
            this.formula = array[1];
        } else if (frontCount==1 && backCount>1) { // if custom separator is "\n"
            separator.add("\n");
            this.formula = formula.substring(4);
        }
        return separator;
    }
    public String getFormula(){
        return this.formula;
    }
    public List<String> separate(String formula, List<String> separator){
        return Arrays.asList(formula.split(separator.getFirst()));
    }
}
