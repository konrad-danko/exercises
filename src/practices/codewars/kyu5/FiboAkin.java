package practices.codewars.kyu5;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FiboAkin {

  //mine submitted
  public static long lengthSupUK(int n, int k) {
    // your code
    return Arrays.stream(getArray(n))
        .filter(x-> x>=k)
        .count();
  }
  public static long comp(int n) {
    // your code
    int[] array = getArray(n);
    return IntStream.rangeClosed(2, n)
        .filter(i-> array[i]<array[i-1])
        .count();
  }
  private static int[] getArray(int n){
    if (n<2) throw new IllegalArgumentException("Parameter 'n' must be greater than 1.");
    int[] u = new int[n+1];
    u[1] = 1;
    u[2] = 1;
    for (int i = 3; i <=n ; i++){
      u[i] = u[i-u[i-1]] + u[i-u[i-2]];
    }
    return u;
  }

  public static void main(String[] args) {
    System.out.println(getArray(900)[900]);
    System.out.println(getArray(90000)[90000]);
    System.out.println("");

    System.out.println(lengthSupUK(23, 12));
    System.out.println(lengthSupUK(50, 10));
    System.out.println(lengthSupUK(500, 100));
    System.out.println("");

    System.out.println(comp(23));
    System.out.println(comp(100));
    System.out.println(comp(200));

  }
}
