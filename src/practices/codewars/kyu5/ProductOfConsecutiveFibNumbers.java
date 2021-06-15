package practices.codewars.kyu5;

import java.util.Arrays;

public class ProductOfConsecutiveFibNumbers {

  //mine submitted, equal to best practice, clever
  public static long[] productFib(long prod) {
    long secondLast = 0;
    long actualTop = 1;
    while(secondLast * actualTop < prod){
      long newTop = secondLast + actualTop;
      secondLast = actualTop;
      actualTop = newTop;
    }
    return new long[]{secondLast, actualTop, secondLast * actualTop == prod ? 1 : 0};
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(productFib(0)));
    System.out.println(Arrays.toString(productFib(1)));
    System.out.println(Arrays.toString(productFib(2)));
    System.out.println(Arrays.toString(productFib(3)));
    System.out.println(Arrays.toString(productFib(714)));
    System.out.println(Arrays.toString(productFib(800)));
    System.out.println(Arrays.toString(productFib((long) Math.pow(2, 62))));
  }
}
