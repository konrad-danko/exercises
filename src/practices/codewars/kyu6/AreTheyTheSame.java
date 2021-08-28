package practices.codewars.kyu6;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AreTheyTheSame {
  public static boolean comp(int[] a, int[] b) {
    if (a==null || b==null) return false;
    String strA = Arrays.stream(a)
        .map(n -> n*n)
        .sorted()
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("-"));
    String strB = Arrays.stream(b).sorted()
        .mapToObj(String::valueOf)
        .collect(Collectors.joining("-"));
    return strA.equals(strB);
  }
}
