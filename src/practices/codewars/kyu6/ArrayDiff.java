package practices.codewars.kyu6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ArrayDiff {

  //mine submitted
  public static int[] arrayDiff(int[] a, int[] b) {
    // Your code here
    return Arrays.stream(a)
        //.boxed() //lepiej byłoby dać to boxed()
        .mapToObj(x-> Integer.valueOf(x))
        .filter(x-> !Arrays.stream(b)
            //.boxed() //lepiej byłoby dać to boxed()
            .mapToObj(i-> Integer.valueOf(i))
            .collect(Collectors.toList())
            .contains(x))
        .mapToInt(x-> x)
        .toArray();
  }

  //best practices + clever
  public static int[] arrayDiff_bp_cl(int[] a, int[] b) {
    List<Integer> listA = Arrays.stream(a).boxed().collect(Collectors.toList());
    List<Integer> listB = Arrays.stream(b).boxed().collect(Collectors.toList());
    listA.removeAll(listB);
    return listA.stream().mapToInt(e -> e).toArray();

  }
}
