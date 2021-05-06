package practices.codewars.kyu6;

import java.util.stream.Collectors;

public class BreakCamelCase {

  //mine
  public static String camelCase(String input) {
    return input.chars()
        .mapToObj(c-> Character.isUpperCase(c) ?
            " "+ Character.toString(c) :
            Character.toString(c))
        .collect(Collectors.joining());
  }

  //best practice + clever
  public static String camelCase_bp_cl(String input) {
    return input.replaceAll("([A-Z])", " $1");
  }
}
