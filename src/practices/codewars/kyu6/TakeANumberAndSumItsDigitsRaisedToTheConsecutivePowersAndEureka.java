package practices.codewars.kyu6;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class TakeANumberAndSumItsDigitsRaisedToTheConsecutivePowersAndEureka {
  public static List<Long> sumDigPow(long a, long b) {
    // your code
    return LongStream.rangeClosed(a,b)
        .filter(n-> isTheNumber(n))
        .boxed()
        .collect(Collectors.toList());
  }
  private static boolean isTheNumber(long number){
    String strNumber = String.valueOf(number);
    return number == LongStream.range(0, strNumber.length())
        .map(i -> (int) Math.pow(Character.getNumericValue(strNumber.charAt((int) i)), i+1))
        .sum();
  }

  public static void main(String[] args) {
    for (long l=1 ; l<=10000000; l++) {
      if (isTheNumber(l)) System.out.println(l);
    }
  }
}
