package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Separator separator = new Separator();

        String formula = Console.readLine();
        String[] numbers = separator.separate(formula);
    }
}