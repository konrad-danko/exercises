package practices.codewars.kyu6;

import java.util.Arrays;

public class TwoSum {
  public static int[] twoSum(int[] numbers, int target) {
    for (int i=0; i<numbers.length; i++) {
      for (int j=i; j<numbers.length; j++) {
        if (numbers[i] + numbers[j] == target) return new int[] {i,j};
      }
    }
    return null; // Do your magic!
  }
}
