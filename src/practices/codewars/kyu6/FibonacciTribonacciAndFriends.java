package practices.codewars.kyu6;

import java.util.Arrays;
import java.util.stream.IntStream;

public class FibonacciTribonacciAndFriends {

  //mine
  public static double[] xbonacci(double[] signature, int n) {
    int xFactor = signature.length;
    double[] result = Arrays.copyOf(signature, n);

    for (int i=xFactor ;  i<Math.min(xFactor*2, n) ; i++){
      for (int j=i-xFactor ; j<i ; j++){
        result[i] = result[i] + result[j];
      }
    }
    for (int i=xFactor*2 ; i<n ; i++){
      result[i] = result[i-1]*2 - result[i-xFactor-1];
    }
    return  result;
  }

  //clever
  public static double[] xbonacci_cl(double[] signature, int n) {
    int x = signature.length;
    double[] result = Arrays.copyOf(signature, n);
    for (int i = x; i < n; i++)
      result[i] = IntStream.range(i-x, i).mapToDouble(k -> result[k]).sum();
    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString((xbonacci(new double []{1,1,1,1},10))));
    System.out.println(Arrays.toString((xbonacci(new double []{0,0,0,0,1},10))));
    System.out.println(Arrays.toString((xbonacci(new double []{1,0,0,0,0,0,1},10))));
    System.out.println(Arrays.toString((xbonacci(new double []{0.0, 1.0, 5.0, 7.0, 11.0, 5.0, 10.0, 6.0, 19.0, 6.0, 7.0, 12.0, 15.0, 18.0, 15.0, 11.0, 2.0},67))));
  }
}
