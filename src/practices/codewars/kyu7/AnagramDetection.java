package practices.codewars.kyu7;

import java.util.Arrays;

public class AnagramDetection {
  public static boolean isAnagram(String test, String original) {
    return Arrays.equals(
        test.toLowerCase().chars().sorted().toArray(),
        original.toLowerCase().chars().sorted().toArray());
  }

  public static void main(String[] args) {
    System.out.println(isAnagram("apple", "pale"));
  }
}
