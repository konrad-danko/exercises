package practices.codewars.kyu6;

import java.util.stream.IntStream;

public class ARuleOfDivisibilityBy13 {

  public static long thirt(long n) {
    // your code
    while (n>getSubSum(n)){
      n = getSubSum(n);
    }
    return n;
  }

  private static long getSubSum (long n) {
    int[] nArray = new StringBuilder(n + "")
        .reverse()
        .chars()
        .map(Character::getNumericValue)
        .toArray();
    return IntStream.range(0, nArray.length)
        .map(x-> (int) (Math.pow(10, x%6)%13)*nArray[x])
        .sum();
  }

  //best practice  / clever
  private static final int[] seq = new int[]{1,10,9,12,3,4};

  public static long thirt_bp_cl(long n) {

    long v = 0, m = n;
    int p = 0;
    while (m>0) {
      v += (m%10)*seq[p++%6];
      m /= 10;
    }
    return v == n ? v : thirt(v);
  }
}
