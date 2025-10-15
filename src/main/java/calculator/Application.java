package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String separator = "";
        String formula = Console.readLine();
        formula = formula.replace("\\n", "\n");

        int frontCount = (formula.length() - formula.replace("//", "").length())/2;
        int backCount = formula.length() - formula.replace("\n", "").length();

        // custom separator
        if (frontCount>=1 && backCount==1){
            String[] array = formula.split("\n");
            separator = array[0].substring(2);
            formula = array[1];
        } else if (frontCount==1 && backCount>1) { // if custom separator is "\n"
            separator = "\n";
            formula = formula.substring(6);
        }
    }
}