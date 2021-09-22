package practices.codewars.kyu6;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConvertStringToCamelCase {
  static String toCamelCase(String s){
    String[] strArray = s.split("-|_");
    return strArray[0] + IntStream.range(1, strArray.length)
        .mapToObj(n-> strArray[n])
        .map(str -> (""+ str.charAt(0)).toUpperCase() + str.substring(1))
        .collect(Collectors.joining());
  }
}
