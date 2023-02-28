package practices.codewars.kyu7;

import java.util.Arrays;

public class IndexedCapitalization {
  public static String capitalize(String s, int[] ind){
    char[] chars = s.toCharArray();
    Arrays.stream(ind)
        .filter(i-> i < chars.length)
        .forEach(n-> chars[n] = Character.toUpperCase(chars[n]));
    return String.valueOf(chars);
  }
}
