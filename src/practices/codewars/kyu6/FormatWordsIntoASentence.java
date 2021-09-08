package practices.codewars.kyu6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FormatWordsIntoASentence {

  public static String formatWords(String[] words) {
    // Do the things...
    if (words==null) return "";

    List<String> listFiltered = Arrays.stream(words)
        .filter(word -> word.length() > 0)
        .collect(Collectors.toList());

    String result = String.join(", ", listFiltered);
    int index = result.lastIndexOf(",");
    return index==-1?
        result:
        result.substring(0, index) + " and"+ result.substring(index+1);
  }
}
