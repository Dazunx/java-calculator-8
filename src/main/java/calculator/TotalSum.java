package calculator;

import java.util.List;

public class TotalSum {
    public int add(List<String> numbers) throws IllegalArgumentException {
        int total = 0;
        if (numbers.isEmpty()){
            throw new IllegalArgumentException();
        }
        for(String n:numbers){
            if(n.contains("-") || n.contains(("+")) || n.isEmpty()){
                throw new IllegalArgumentException();
            }
            total += Integer.parseInt(n);
        }
        return total;
    }
}