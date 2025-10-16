package calculator;

public class Separator {
    public String setSeparator(String formula) {
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
    public String[] separate(String formula){
        String customSeparator = setSeparator(formula);
        String[] numbers;

        // separate using custom separator
        if (!customSeparator.isEmpty()){
            numbers = formula.split(customSeparator);
        }
        // separate using default separator
        else {
            String[] numbers1 = formula.split(",");
            String[] numbers2 = formula.split(";");
            numbers = new String[numbers1.length + numbers2.length];
            System.arraycopy(numbers1, 0, numbers,0, numbers1.length);
            System.arraycopy(numbers2, 0, numbers, numbers1.length, numbers2.length);
        }
        return numbers;
    }
}