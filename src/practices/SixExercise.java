package practices;

import java.util.Arrays;
import java.util.stream.Collectors;

public class SixExercise {

  public static void main(String[] args) {

    String[] myArray = new String[]{"bob", "alice", "paul", "ellie"};

    System.out.println(Arrays.stream(myArray)
        .map(s-> s.toUpperCase())
        .collect(Collectors.joining(" ")));

    String[] strings = Arrays.stream(myArray)
        .map(String::toUpperCase)
        .toArray(String[]::new);

  }
  public static String getUpperCaseOfArrayElements(String[] myArray) {
    return Arrays.stream(myArray)
        .map(s-> s.toUpperCase())
        .collect(Collectors.joining(" "));
  }

}
