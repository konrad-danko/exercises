package practices.codewars.kyu6;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MultiplicationTable {
  public static int [][] multiplicationTable(int n){
    int[][] result = new int[n][n];
    for (int i=0; i<n; i++){
      for (int j=0; j<n; j++){
        result[i][j] = (i+1)*(j+1);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int n = 3;
    int[][] ints = IntStream.rangeClosed(1, n)
        .mapToObj(i-> IntStream.rangeClosed(1,n)
            .map(j-> i*j)
            .toArray())
        .toArray(int[][]::new);

    System.out.println(Arrays.deepToString(ints));
  }
}
