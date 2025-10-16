package calculator;

import java.util.List;

public class TotalSum {
    public int add(List<String> numbers) throws IllegalArgumentException {
        int total = 0;
        for(String n:numbers){
            total += Integer.parseInt(n);
        }
        return total;
    }
}
