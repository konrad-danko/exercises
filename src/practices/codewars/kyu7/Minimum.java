package practices.codewars.kyu7;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Minimum {
  public static int minValue(int[] values){
    String s = Arrays.stream(values)
        .distinct()
        .sorted()
        //.mapToObj(Integer::toString)
        //.mapToObj(i-> i+"")
        //.mapToObj(i-> String.valueOf(i))
        .mapToObj(String::valueOf)
        .collect(Collectors.joining(""));
    return Integer.parseInt(s);
  }
}
