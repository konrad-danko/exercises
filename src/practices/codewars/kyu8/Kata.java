package practices.codewars.kyu8;

import java.util.Arrays;

public class Kata {
  public static int[] digitize(long n) {
    String stringNumber = ((Long)n).toString();
    int resultLength = stringNumber.length();
    int[] result = new int[resultLength];
    for (int i=resultLength-1; i>=0 ; i--){
      int digit = Integer.parseInt(String.valueOf(stringNumber.charAt(i)));
      result[resultLength - 1 - i] = digit;
    }
    return result;
  }

  public static int[] digitize2(long n) {
    StringBuilder stringBuilder = new StringBuilder();
    return stringBuilder
        .append(n)
        .reverse()
        .chars().map(Character::getNumericValue)
        .toArray();
  }



  public static void main(String[] args) {
    System.out.println(Arrays.toString(digitize2(348597)));
    System.out.println(Arrays.toString(digitize2(0)));
  }
}

