package practices.codewars.kyu5;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SimplePigLatin {
  public static String pigIt(String str) {
    // Write code here
    return Arrays.stream(str.split(" "))
        .map(word ->
            word.matches("^([!\\?])$")?
            word:
            word.substring(1) + word.charAt(0) + "ay")
        .collect(Collectors.joining(" "));
  }
}
