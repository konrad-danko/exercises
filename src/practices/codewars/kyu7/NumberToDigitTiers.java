package practices.codewars.kyu7;

import java.util.Arrays;
import java.util.stream.IntStream;

public class NumberToDigitTiers {

  public static String[] createArrayOfTiers(int num) {
    String numStr = String.valueOf(num);
    return IntStream.rangeClosed(1, numStr.length())
        .mapToObj(n -> numStr.substring(0, n))
        .toArray(String[]::new);
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(createArrayOfTiers(420)));
  }
}
