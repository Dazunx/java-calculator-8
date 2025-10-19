package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Separator separator = new Separator();
        TotalSum totalSum = new TotalSum();
        String formula;

        try {
            formula = Console.readLine();
        } catch (Exception e) {
            System.out.println("결과 : 0");
            return;
        }
        List<String> numbers = separator.separate(formula);
        int total = totalSum.add(numbers);
        System.out.println("결과 : " + total);
    }
}