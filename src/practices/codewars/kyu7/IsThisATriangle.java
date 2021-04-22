package practices.codewars.kyu7;

import java.util.Arrays;

public class IsThisATriangle {
  public static boolean isTriangle(int a, int b, int c){
    int[] array = {a, b, c};
    Arrays.sort(array);
    return array[0] + array[1] > array[2];
  }

  //clever and best practice
  public static boolean isTriangle_CL_BP(int a, int b, int c){
    return a + b > c && a + c > b && c + b > a;
  }
}
