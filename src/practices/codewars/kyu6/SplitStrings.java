package practices.codewars.kyu6;

import java.util.stream.IntStream;

public class SplitStrings {
  public static String[] solution(String s) {
    //Write your code here
    String str = s.length()%2==1? s+"_": s;
    return IntStream.range(0, str.length())
        .filter(n-> n%2==0)
        .mapToObj(index-> str.substring(index, index+2))
        .toArray(String[]::new);
  }
}
