package practices.codewars.kyu7;

import java.util.List;
import java.util.stream.Collectors;

public class ListFiltering {

  public static List filterList(final List<Object> list) {
    // Return the List with the Strings filtered out
    return list.stream()
        .filter(ob-> !(ob instanceof String))
        .collect(Collectors.toList());
  }

}
