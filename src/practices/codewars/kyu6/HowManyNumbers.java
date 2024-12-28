package practices.codewars.kyu6;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HowManyNumbers {

  public static int selNumber(int n, int d) {
    return (int) IntStream.rangeClosed(10, n)
        .filter(i-> isSequential(i))
        .filter(i-> isDistinct(i))
        .filter(i-> isWithinDelta(i, d))
        .count();
  }

  private static boolean isSequential(int number) {
    String originStr = String.valueOf(number);
    String sortedStr = IntStream.range(0, originStr.length())
        .mapToObj(index-> originStr.substring(index, index+1))
        .sorted()
        .collect(Collectors.joining());
    return originStr.equals(sortedStr);
  }

  private static boolean isDistinct(int number) {
    String originStr = String.valueOf(number);
    String distinctStr = IntStream.range(0, originStr.length())
        .mapToObj(index-> originStr.substring(index, index+1))
        .distinct()
        .collect(Collectors.joining());
    return originStr.length() == distinctStr.length();
  }

  private static boolean isWithinDelta(int number, int delta) {
    String originStr = String.valueOf(number);
    List<Integer> list = IntStream.range(0, originStr.length())
        .mapToObj(index-> originStr.substring(index, index+1))
        .map(letter-> Integer.parseInt(letter))
        .collect(Collectors.toList());
    for (int index = 0; index< list.size()-1; index++){
      if ((list.get(index+1) - list.get(index)) > delta){
        return false;
      }
    }
    return true;
  }
}
