package practices.codewars.kyu8;

import java.util.Arrays;

public class SquareNSum {
  public static int squareSum(int[] n) {
    //Your Code
    System.out.println(Arrays.toString(n));
    return Arrays.stream(n)
        .map(x-> x*x)
        .sum();
  }
}
