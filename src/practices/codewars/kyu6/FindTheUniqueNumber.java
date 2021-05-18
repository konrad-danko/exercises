package practices.codewars.kyu6;

import java.util.Arrays;

public class FindTheUniqueNumber {

  //mine submitted
  public static double findUniq(double arr[]) {
    // Do the magic
    if(arr[0]!=arr[1] && arr[1]==arr[2]){
      return arr[0];
    }
    for (int i=0 ; i< arr.length-1 ; i++){
      if (arr[i]!=arr[i+1]) {
        return arr[i+1];
      }
    }
    return -1;
  }

  //best practice + clever
  public static double findUniq_bp_cl(double arr[]) {
    Arrays.sort(arr);
    return arr[0] == arr[1] ? arr[arr.length-1] : arr[0];
  }
}
