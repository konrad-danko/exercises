package practices.codewars.kyu6;

import java.util.ArrayList;
import java.util.List;

public class MakeTheDeadfishSwim {
  public static int[] parse(String data) {
    // Implement me! :)
    List<Integer> resultList = new ArrayList<>();
    int sum = 0;
    for (char c: data.toCharArray()) {
      if (c=='i') sum++;
      if (c=='d') sum--;
      if (c=='s') sum=sum*sum;
      if (c=='o') resultList.add(sum);
    }
    return resultList.stream()
        .mapToInt(x-> x)
        .toArray();
  }
}
