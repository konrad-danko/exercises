package practices.codewars.kyu7;

import java.util.Arrays;
import java.util.stream.IntStream;

public class RowWeights {
  //mine
  public static int[] rowWeights (final int[] weights) {
    int[] result = new int[2];
    IntStream.range(0, weights.length)
        .forEach(n-> result[n%2] += weights[n]);
    return result;
  }

  //clever
  public static int[] rowWeights_cl (final int[] weights) {
    int totals[] = new int[2], idx = 0;
    for (int w : weights) totals[(idx++)%2] += w;
    return totals;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(rowWeights(new int[] {13, 27, 49})));
    System.out.println(Arrays.toString(rowWeights(new int[] {50, 60, 70, 80})));
    System.out.println(Arrays.toString(rowWeights(new int[] {80})));
  }
}
