package practices.codewars.kyu7;

import java.util.Arrays;

public class TheHighestProfitWins {
  public static int[] minMax(int[] arr) {
    // Your awesome code here
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for(int n: arr){
      min = Math.min(min, n);
      max = Math.max(max, n);
    }
    return new int[] {min, max};
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(minMax(new int[]{1,2,3,4,5})));
    System.out.println(Arrays.toString(minMax(new int[]{2334454,5})));
    System.out.println(Arrays.toString(minMax(new int[]{1})));
  }
}
