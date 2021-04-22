package practices.codewars.kyu8;

import java.util.Arrays;

public class SumOfPositive {
  public static int sum(int[] arr){
    return arr==null || arr.length==0 ?
        0 :
        Arrays.stream(arr).filter(x-> x>0).sum();
  }
}
