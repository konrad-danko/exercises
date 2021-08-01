package practices.codewars.kyu6;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConsecutiveStrings {
  public static String longestConsec(String[] strarr, int k) {
    // your code
    String result = "";
    for(int startIndex=0 ; startIndex<=strarr.length-k ; startIndex++){
      String temp = IntStream.range(startIndex, startIndex+k)
          .mapToObj(x-> strarr[x])
          .collect(Collectors.joining());
      result = temp.length()>result.length() ? temp : result;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(longestConsec(new String[]{"ejjjjmmtthh", "zxxuueeg", "aanlljrrrxx", "dqqqaaabbb", "oocccffuucccjjjkkkjyyyeehh"}, 1));
  }
}
