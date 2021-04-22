package practices.codewars.kyu8;

import java.util.Arrays;

public class CountOfPositivesSumOfNegatives {
  public static int[] countPositivesSumNegatives(int[] input) {
    if (input==null || input.length==0) {
      return new int[0];
    }
    int[] result = new int[2];
    result[0] = (int) Arrays.stream(input).filter(x-> x>0).count();
    result[1] = Arrays.stream(input).filter(x-> x<0).sum();
    return result;
  }
}
