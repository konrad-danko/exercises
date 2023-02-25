package practices.codewars.kyu6;

import java.util.Arrays;
import java.util.stream.Collectors;

public class PairOfGloves {
  public static int numberOfPairs(String[] gloves) {
    return Arrays.stream(gloves)
        .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
        .values().stream()
        .mapToInt(i -> (int) (i/2))
        .sum();
  }
}
