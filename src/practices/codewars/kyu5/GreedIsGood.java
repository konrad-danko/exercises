package practices.codewars.kyu5;

import java.util.Arrays;
import java.util.stream.Collectors;

public class GreedIsGood {
  public static int greedy(int[] dice){
    //code here
    String[][] scoringTable = {
        {"111", "1000"},
        {"666", "600"},
        {"555", "500"},
        {"444", "400"},
        {"333", "300"},
        {"222", "200"},
        {"11", "200"},
        {"55", "100"},
        {"1", "100"},
        {"5", "50"}};
    String diceStr = Arrays.stream(dice)
        .sorted()
        .mapToObj(s-> ""+s)
        .collect(Collectors.joining());
    int result = 0;

    for (String[] strings : scoringTable) {
      if (diceStr.contains(strings[0])) {
        result = result + Integer.parseInt(strings[1]);
        diceStr = diceStr.replaceAll(strings[0], "");
      }
    }
    return result;
  }
}
