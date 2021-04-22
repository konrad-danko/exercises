package practices.codewars.kyu7;

import java.util.stream.IntStream;

public class MaximumProduct {
  public int adjacentElementsProduct(int[] array) {
    int result = array[0]*array[1];
    for (int i=1 ; i<array.length-1; i++){
      result = Math.max(array[i] * array[i + 1], result);
    }
    return result;
  }

  //clever
  public int adjacentElementsProduct_cl(int[] array) {
    return IntStream.range(0, array.length - 1)
        .map(x -> array[x]*array[x+1])
        .max()
        .orElse(Integer.MIN_VALUE);
  }
}
