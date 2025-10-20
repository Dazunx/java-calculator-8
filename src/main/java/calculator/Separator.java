package calculator;

import java.util.List;

public interface Separator {
    List<String> extractSeparator(String formula);
    List<String> separate(String formula);
}
