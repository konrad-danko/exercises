package practices.codewars.kyu7;

import java.util.stream.IntStream;

public class SumOfTriangularNumbers {
  public static int sumTriangularNumbers(int n) {
    return (n<0) ? 0 : IntStream.range(1, n+1).map(x-> x*(n+1-x)).sum();
  }

  //clever
  public static int sumTriangularNumbers_Cl(int n) {
    return (n <= 0) ? 0 : n*(n+1)*(n+2)/6;
  }

  public static void main(String[] args) {
    System.out.println(sumTriangularNumbers(4));
    System.out.println(sumTriangularNumbers(6));
    System.out.println(sumTriangularNumbers(34));
    System.out.println(sumTriangularNumbers(-291));
  }
}
