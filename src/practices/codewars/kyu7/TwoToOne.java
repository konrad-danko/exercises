package practices.codewars.kyu7;

import java.util.stream.Collectors;

public class TwoToOne {

  public static String longest (String s1, String s2) {
    // your code
    return (s1 + s2).chars()
        .mapToObj(Character::toString)
        .distinct()
        .sorted()
        .collect(Collectors.joining());
  }

  public static void main(String[] args) {
    System.out.println(longest("aretheyhere", "yestheyarehere"));
  }
}
