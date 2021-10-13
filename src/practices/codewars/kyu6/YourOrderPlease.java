package practices.codewars.kyu6;

import java.util.Arrays;
import java.util.stream.Collectors;

public class YourOrderPlease {
  public static String order(String words) {
    // ...
    return Arrays.stream(words.split(" "))
        .sorted((a,b)-> a.toLowerCase().replaceAll("[a-z]", "")
            .compareTo(b.toLowerCase().replaceAll("[a-z]", "")))
        .collect(Collectors.joining(" "));
  }
}
