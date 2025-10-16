package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Separator separator = new Separator();
        TotalSum totalSum = new TotalSum();

        String formula = Console.readLine();
        List<String> numbers = separator.separate(formula);
        try{
            int total = totalSum.add(numbers);
            System.out.println("결과 : " + total);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }
}