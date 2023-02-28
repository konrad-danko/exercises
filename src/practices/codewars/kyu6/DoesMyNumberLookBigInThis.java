package practices.codewars.kyu6;

import java.util.stream.IntStream;

public class DoesMyNumberLookBigInThis {
  public static boolean isNarcissistic(int number) {
    String strNumber = String.valueOf(number);
    int power = strNumber.length();
    int sum = IntStream.range(0, power)
        .mapToObj(index -> Integer.parseInt(String.valueOf(strNumber.charAt(index))))
        .mapToInt(num -> (int) Math.pow(num, power))
        .sum();
    return sum == number;
  }
}
