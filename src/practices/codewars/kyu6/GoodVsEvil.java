package practices.codewars.kyu6;

import java.util.stream.IntStream;

public class GoodVsEvil {

  public static String battle(String goodAmounts, String evilAmounts) {
    if (getSum(goodAmounts) > getSum(evilAmounts)){
      return  "Battle Result: Good triumphs over Evil";
    }
    if (getSum(goodAmounts) < getSum(evilAmounts)){
      return "Battle Result: Evil eradicates all trace of Good";
    }
    return "Battle Result: No victor on this battle field";
  }

  private static int getSum(String str){
    String[] split = str.split(" ");
    int[] worthsArr = split.length == 6? new int[]{1, 2, 3, 3, 4, 10} : new int[]{1, 2, 2, 2, 3, 5, 10};
    return IntStream.range(0, split.length)
        .map(i->  Integer.parseInt(split[i]) * worthsArr[i])
        .reduce(0, (a, b) -> a + b);
  }

  public static void main(String[] args) {
    System.out.println("Good " + getSum("8005 7708 328 9783 5326 1825"));
    System.out.println("Evil " + getSum("1735 4007 2001 2016 1030 9852 8991"));
  }
}
