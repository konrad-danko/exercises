package practices.codewars.kyu5;

import java.util.stream.IntStream;

public class SquareMatrixMultiplication {
  public static int[][] matrixMultiplication(int[][] a, int[][] b) {

    int size = a.length;
    return IntStream.range(0, size)
        .mapToObj(row-> IntStream.range(0, size)
            .map(col-> IntStream.range(0, size)
                .map(i-> a[row][i] * b[i][col])
                .sum())
            .toArray())
        .toArray(int[][]::new);

/*    int[][] resultArr = new int[size][];
    for(int row=0; row<size; row++){
      int[] rowArr = new int[size];
      for(int col=0; col<size; col++){
        int value = 0;
        for(int i=0; i<size; i++){
          value = value + a[row][i] * b[i][col];
        }
        rowArr[col] = value;
      }
      resultArr[row] = rowArr;
    }
		return resultArr;*/

  }
}
