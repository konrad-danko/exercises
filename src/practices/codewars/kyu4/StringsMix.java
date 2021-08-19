package practices.codewars.kyu4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StringsMix {
  //mine improved:
  public static String mix_impr(String s1, String s2) {
    // your code:
    List<String> resultList = new ArrayList<>();
    for (int code=97; code<=122; code++) {
      String charsOfS1 = getChars(s1, (char) code, 1);
      String charsOfS2 = getChars(s2, (char) code, 2);
      int length1 = charsOfS1.length();
      int length2 = charsOfS2.length();
      if (length1<=3 && length2<=3) continue;
      if (length1==length2) {
        resultList.add(charsOfS1.replaceAll("1", "="));
      } else {
        resultList.add(length1>length2 ? charsOfS1 : charsOfS2);
      }
    }
    return resultList.stream()
        .sorted(Comparator.comparingInt(String::length)
            .reversed()
            .thenComparing(Comparator.naturalOrder()))
        .collect(Collectors.joining("/"));
  }
  private static String getChars(String str, char c, int id) {
    return id + ":" + str.chars()
        .filter(x -> x==c)
        .mapToObj(Character::toString)
        .collect(Collectors.joining());
  }
  //mine submitted:
  public static String mix(String s1, String s2) {
    // your code:
    int maxLength = Math.max(s1.length(), s2.length());
    String zeros = String.valueOf(maxLength).replaceAll("\\d", "0");
    List<String> resultList = new ArrayList<>();

    for (int code=97; code<=122; code++) {
      String charsOfS1 = getChars(s1, (char) code, 1);
      String charsOfS2 = getChars(s2, (char) code, 2);
      int length1 = charsOfS1.length();
      int length2 = charsOfS2.length();
      if (length1<=3 && length2<=3) continue;
      String strToAdd;
      if (length1==length2) {
        strToAdd = charsOfS1.replaceAll("1", "=");
      } else {
        strToAdd = length1>length2 ? charsOfS1 : charsOfS2;
      }
      int sortingNumber = maxLength-strToAdd.length()+2;
      int numberOfZeros = zeros.length() - String.valueOf(sortingNumber).length();
      String leadingZeros = zeros.substring(0,numberOfZeros);
      resultList.add(leadingZeros + sortingNumber + "-" + strToAdd);
    }

    return resultList.stream()
        .sorted()
        .map(str-> str.substring(str.indexOf("-")+1))
        .collect(Collectors.joining("/"));
  }

  public static void main(String[] args) {
    System.out.println(mix_impr("Are they here", "yes, they are here"));
    System.out.println(mix_impr("looping is fun but dangerous", "less dangerous than coding"));
  }
}
