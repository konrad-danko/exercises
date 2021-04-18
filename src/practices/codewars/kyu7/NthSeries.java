package practices.codewars.kyu7;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.IntStream;

public class NthSeries {

  //tak poszło jako solution:
  public static String seriesSum_v1(int n) {
    double sumStream =  IntStream.range(0, 3*n)
        .filter(item-> item%3==0)
        .asDoubleStream()
        .map(item-> 1/(item+1))
        .sum();
    return new BigDecimal(sumStream).setScale(2, RoundingMode.HALF_UP).toString();
  }

  //to jest Best Practice:
  public static String seriesSum_v2(int n) {
    double sum = 0.0;
    for (int i=0 ; i<n ; i++) {
      sum = sum + 1.0/(1+3*i);
    }
    return String.format("%.2f", sum).replaceAll(",", ".");
  }

  //to jest Clever:
  public static String seriesSum(int n) {
    double sum = IntStream.range(0, n)
        .mapToDouble(x-> 1.0/(1+3*x))
        .sum();
    return String.format("%.2f", sum).replaceAll(",", ".");
  }


  public static void main(String[] args) {
    System.out.println("0: " + seriesSum(0));
    System.out.println("1: " + seriesSum(1));
    System.out.println("2: " + seriesSum(2));
    System.out.println("5: " + seriesSum(5));
    System.out.println("9: " + seriesSum(9));
    System.out.println("15: " + seriesSum(15));
  }
}
