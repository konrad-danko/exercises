package practices.coderbyte;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class TreeConstructor {
  public static String treeConstructor(String[] strArr) {
    // code goes here

    boolean check1 = Arrays.stream(strArr)
        .collect(Collectors.groupingBy(s -> s.split(",")[1], Collectors.counting()))
        .values().stream()
        .max(Long::compareTo)
        .get()<3;

    boolean check2 = Arrays.stream(strArr)
        .collect(Collectors.groupingBy(s -> s.split(",")[0], Collectors.counting()))
        .values().stream()
        .max(Long::compareTo)
        .get()==1;

    Set<String> setChild = Arrays.stream(strArr)
        .map(s -> s.replaceAll("\\(","").split(",")[0])
        .collect(Collectors.toSet());

    Set<String> setParent = Arrays.stream(strArr)
        .map(s -> s.replaceAll("\\)","").split(",")[1])
        .collect(Collectors.toSet());

    boolean check3 = setParent.stream()
        .filter(s-> !setChild.contains(s))
        .count() == 1;
/*
    System.out.println(setChild);
    System.out.println(setParent);
    System.out.println(setParent.stream()
        .filter(s-> !setChild.contains(s))
        .count());*/

    return check1 && check2 && check3? "true":"false";
  }

  public static void main(String[] args) {



    //System.out.println(treeConstructor(new String[] {"(2,3)", "(1,2)", "(4,9)", "(9,3)", "(12,9)", "(6,4)"}));
    //System.out.println(treeConstructor(new String[] {"(2,3)", "(1,2)", "(4,9)", "(9,3)", "(12,9)", "(6,4)", "(1,9)"}));
    //System.out.println(treeConstructor(new String[] {"(1,2)", "(2,4)", "(7,4)"}));
    //System.out.println(treeConstructor(new String[] {"(5,6)", "(6,3)", "(2,3)", "(12,5)"}));

    System.out.println(treeConstructor(new String[] {"(2,5)", "(2,6)"}));
    System.out.println(treeConstructor(new String[] {"(10,20)"}));
    System.out.println(treeConstructor(new String[] {"(2,3)", "(1,2)", "(4,9)", "(9,3)", "(12,9)", "(6,4)"}));
    System.out.println(treeConstructor(new String[] {"(2,3)", "(1,2)", "(4,9)", "(9,3)", "(12,9)", "(6,4)", "(1,9)"}));
    System.out.println(treeConstructor(new String[] {"(1,2)", "(2,4)", "(7,4)"}));
    System.out.println(treeConstructor(new String[] {"(1,2)", "(2,4)", "(7,4)", "(70,40)"}));
    //System.out.println(treeConstructor());
  }
}
