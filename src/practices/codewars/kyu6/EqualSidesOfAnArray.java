package practices.codewars.kyu6;

import java.util.Arrays;

public class EqualSidesOfAnArray {
  public static int findEvenIndex(int[] arr) {
    // your code:
    for (int index=0; index<arr.length; index++) {
      int sumLeft = Arrays.stream(arr, 0, index).sum();
      int sumRight = Arrays.stream(arr, index+1, arr.length).sum();
      if (sumLeft==sumRight) return index;
    }
    return -1;
  }
}
