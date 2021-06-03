package practices.codewars.kyu5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindTheSmallest {

  //mine submitted:
  public static long[] smallest(long n) {
    // your code
    long[] result = {n, 0, 0};
    String strNumber = String.valueOf(n);
    for (int oldInd = 0; oldInd < strNumber.length() ; oldInd++) {
      for (int newInd = 0; newInd < strNumber.length() ; newInd++) {
        long minNumber = Long.parseLong(reShape(strNumber, oldInd, newInd));
        if (minNumber <result[0]){
          result[0] = minNumber;
          result[1] = oldInd;
          result[2] = newInd;
        }
      }
    }
    return result;
  }
  private static String reShape(String str, int oldIndex, int newIndex){
    List<String> resultList = str.chars().mapToObj(Character::toString).collect(Collectors.toList());
    resultList.remove(oldIndex);
    resultList.add(newIndex, "" + str.charAt(oldIndex));
    return String.join("", resultList);
  }

  //best practice + clever
  public static long[] smallest_bp_cl(long n) {
    long min = n;
    int index1 = 0;
    int index2 = 0;
    String number = String.valueOf(n);
    for (int i=0; i<number.length(); i++) {
      for (int j=0; j<number.length(); j++) {
        if (i!=j && making(number, i, j) < min) {
          min = making(number, i, j);
          index1 = i;
          index2 = j;
        }
      }
    }
    return new long[]{min, index1, index2};
  }
  public static long making(String s, int i, int j) {
    StringBuilder sb = new StringBuilder(s);
    char c = sb.charAt(i);
    sb.deleteCharAt(i);
    sb.insert(j, c);
    return Long.valueOf(sb.toString());
  }


  public static void main(String[] args) {
    System.out.println(Arrays.toString(smallest_bp_cl(261235)));
    System.out.println(Arrays.toString(smallest_bp_cl(209917)));
    System.out.println(Arrays.toString(smallest_bp_cl(1000000)));

    StringBuilder stringBuilder = new StringBuilder("123456789");
    System.out.println(stringBuilder.charAt(0));
    System.out.println(stringBuilder.codePointAt(0));
  }
}
