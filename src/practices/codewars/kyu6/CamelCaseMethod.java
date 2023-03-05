package practices.codewars.kyu6;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CamelCaseMethod {

  public static String camelCase(String str) {
    return Arrays.stream(str.trim().split(" "))
        .map(s-> convertToCamel(s))
        .collect(Collectors.joining());
  }

  private static String convertToCamel(String text){
    if(text==null || text.length()==0){
      return text;
    }
    char[] chars = text.toCharArray();
    chars[0] = Character.toUpperCase(chars[0]);
    return String.valueOf(chars);
  }
}
