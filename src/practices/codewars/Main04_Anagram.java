package practices.codewars;

import java.util.*;
import java.util.stream.Collectors;

public class Main04_Anagram {

  public static List<List<String>> groupAnagrams(List<String> words) {
    // your solution goes here

/*    Set<String> set = new HashSet<>();
    words.stream()
        .map(s-> sortChars(s.toLowerCase()))
        .forEach(x-> set.add(x));*/

/*    Set<String> set = words.stream()
        .map(s-> sortChars(s.toLowerCase()))
        .collect(Collectors.toSet());*/

/*    List<List<String>> resultList = new ArrayList<>();

    for (String setStr: set) {
      List<String> subList = new ArrayList<>();
      for (String word: words) {
        if (setStr.equals(sortChars(word.toLowerCase()))) {
          subList.add(word);
        }
      }
      resultList.add(subList);
    }
    return resultList;*/

/*    return words.stream()
        .map(s-> sortChars(s))
        .collect(Collectors.toSet())
        .stream()
        .map(s ->
            words.stream()
                .filter(x -> s.equals(sortChars(x)))
                .collect(Collectors.toList()))
        .collect(Collectors.toList());*/

    return new ArrayList<>(
        words.stream()
        .collect(Collectors.groupingBy(s -> sortChars(s)))
        .values()
    );
  }

  private static String sortChars(String source) {
    return source.toLowerCase()
        .chars()
        .sorted()
        .mapToObj(x-> String.valueOf((char) x))
        .collect(Collectors.joining());
  }

  public static void main(String[] args) {
    System.out.println(groupAnagrams(List.of()));
    System.out.println(groupAnagrams(List.of("tn", "cab", "vwa", "bca", "nt", "abc")));
    System.out.println(groupAnagrams(List.of("Tn", "cab", "vwa", "BCA", "nt", "abc")));
  }
}
