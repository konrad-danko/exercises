package practices.coderbyte;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindIntersection {
  public static String findIntersection(String[] strArr) {
    // code goes here
    List<String> listA = Arrays.stream(strArr[0].split(", "))
        .collect(Collectors.toList());
    List<String> listB = Arrays.stream(strArr[1].split(", "))
        .collect(Collectors.toList());

    listA.retainAll(listB);

    return listA.size()==0 ?
        "false" :
        listA.stream().collect(Collectors.joining(","));
  }

  public static void main(String[] args) {
    System.out.println(findIntersection(new String[] {"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"}));
    System.out.println(findIntersection(new String[] {"2, 5, 7, 10, 11, 12", "2, 7, 8, 9, 10, 11, 15"}));
    System.out.println(findIntersection(new String[] {"1, 3, 9, 10, 17, 18", "1, 4, 9, 10"}));
    System.out.println(findIntersection(new String[] {"11, 12, 14, 16, 20", "11, 12, 13, 18, 21"}));
    System.out.println(findIntersection(new String[] {"1, 2, 4, 5, 6, 9", "2, 3, 4, 8, 10"}));
    System.out.println(findIntersection(new String[] {"5, 6, 9, 11, 12, 16", "4, 6, 7, 11, 16"}));
    System.out.println(findIntersection(new String[] {"21, 22, 23, 25, 27, 28", "21, 24, 25, 29"}));
    System.out.println(findIntersection(new String[] {"2, 3, 4", "3"}));
    //System.out.println(findIntersection(new String[] {}));
  }
}
