package practices.codewars.kyu8;

import java.util.Arrays;

public class Maps {
  public static int[] map(int[] arr) {
/*    int[] result = new int[arr.length];
    for (int i=0 ; i< arr.length; i++) {
      result[i] = arr[i]*2;
    }
    return result;*/
    return Arrays.stream(arr)
        .map(x -> x*2)
        .toArray();
  }

  public static void main(String[] args) {
    int[] array = {1,2,3,8,0,-4};
    System.out.println(Arrays.toString(map(array)));
  }
}
