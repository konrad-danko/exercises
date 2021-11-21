package practices.codewars.kyu7;

import java.util.Comparator;
import java.util.stream.Collectors;

public class DescendingOrder {
  public static int sortDesc(final int num) {
    //Your code
    return Integer.parseInt(String.valueOf(num).chars()
        .mapToObj(Character::getNumericValue)
        .sorted(Comparator.reverseOrder())
        .map(String::valueOf)
        .collect(Collectors.joining()));
  }
}
