package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SeparatorExecutor {
    CustomSeparator customSeparator = new CustomSeparator();
    DefaultSeparator defaultSeparator = new DefaultSeparator();

    public List<String> separationExecutor (String formula){
        List<String> customSeparatedList;
        List<String> separatedList = new ArrayList<>();

        // extract custom and default separator
        customSeparator.separator = customSeparator.extractSeparator(formula);
        defaultSeparator.separator = defaultSeparator.extractSeparator(formula);

        // execute separator using custom and default separator
        if (!customSeparator.separator.isEmpty()){
            customSeparatedList = customSeparator.separate(customSeparator.getFormula(), customSeparator.separator);
            if(!defaultSeparator.separator.isEmpty()) {
                for (String c:customSeparatedList){
                    separatedList.addAll(defaultSeparator.separate(c, defaultSeparator.separator));
                }
            } else {
                separatedList.addAll(customSeparatedList);
            }
        } else{
            separatedList.addAll(defaultSeparator.separate(formula, defaultSeparator.separator));
        }
        return separatedList;
    }
}