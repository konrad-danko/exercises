package practices.codewars.kyu6;

import java.util.Arrays;

public class FindTheOddInt {

  //mine submitted
  public static int findIt(int[] a) {
    for(int item: Arrays.stream(a).distinct().toArray()){
      if (Arrays.stream(a).filter(i-> i==item).count() %2 == 1) {
        return item;
      }
    }
    return -1;
  }

  //best practice + clever
  public static int findIt_bp_cl(int[] A) {
    int xor = 0;
    for (int i = 0; i < A.length; i++) {
      xor ^= A[i];
    }
    return xor;
  }

  //also clever
  public static int findIt_cl(int[] arr) {
    return Arrays.stream(arr).reduce(0, (x, y) -> x ^ y);
  }

  public static void main(String[] args) {
/*    for (int i=0 ; i<=7 ; i++) {
      for (int j=0 ; j<=7 ; j++) {
        System.out.print(i ^ j);
        System.out.print(", ");
      }
      System.out.println("");
    }*/
    System.out.println(((2^2)^2)^2);
    System.out.println((2^2)^2);
    System.out.println(2^2);
    System.out.println(2^2^2);
    System.out.println(2^2^2^2);
    System.out.println(2^2^2^2^2);
    System.out.println(2^2^2^2^2^2);
    System.out.println(2^2^2^2^2^2^2);
    System.out.println(2^2^2^2^2^2^2^2);
    System.out.println(2^2^2^2^2^2^2^2^2);
    System.out.println(2^2^2^2^2^2^2^2^2^2);
  }
}
