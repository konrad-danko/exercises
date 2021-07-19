package practices.codewars.kyu5;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MaximumSubarraySum {

  //mine submitted
  public static int sequence(int[] arr) {
    if (arr.length==0) return 0;
    int countOfPositives = (int) Arrays.stream(arr)
        .filter(i-> i>=0)
        .count();
    if (countOfPositives==0) return 0;

    int maxSum = arr[0];
    for (int i=0 ; i<arr.length ; i++) {
      for (int j=i ; j<arr.length ; j++) {
        int subArraySum = IntStream.rangeClosed(i, j)
            .map(x-> arr[x])
            .sum();
        maxSum = Math.max(maxSum, subArraySum);
      }
    }
    return maxSum;
  }
  //Best practie and clever:
  public static int sequence_BPCL(int[] arr) {
    int max_ending_here = 0, max_so_far = 0;
    for (int v : arr) {
      max_ending_here = Math.max(0, max_ending_here + v);
      max_so_far = Math.max(max_so_far, max_ending_here);
    }
    return max_so_far;
  }
}
