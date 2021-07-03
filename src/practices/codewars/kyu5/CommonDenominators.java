package practices.codewars.kyu5;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CommonDenominators {
  public static String convertFrac(long[][] lst) {
    // your code
    if (lst.length==0) return "";
    Arrays.stream(lst)
        .forEach(x-> {
          long gcd = gcd(x[0], x[1]);
          x[0] = x[0]/gcd;
          x[1] = x[1]/gcd;
        });
    long scm = Arrays.stream(lst)
        .mapToLong(x-> x[1])
        .reduce(lst[0][1], (a,b)-> a*b/gcd(a,b));
    return Arrays.stream(lst)
        .map(item-> "("+ item[0]* scm /item[1] +","+ scm +")")
        .collect(Collectors.joining());
  }
  private static long gcd (long a, long b){
    return BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).longValue();
  }

  public static void main(String[] args) {
    long[][] lst = { {1, 2}, {1, 3}, {10, 40} };
    System.out.println(convertFrac(lst));
  }
}
