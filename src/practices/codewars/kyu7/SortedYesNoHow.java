package practices.codewars.kyu7;

import java.util.stream.IntStream;

public class SortedYesNoHow {

  //tak jest krócej
  public static String isSortedAndHow_v2(int[] array) {
    if(IntStream.range(0, array.length-1).allMatch(i -> array[i] <= array[i+1]))
      return "yes, ascending";
    if(IntStream.range(0, array.length-1).allMatch(i -> array[i] >= array[i+1]))
      return "yes, descending";
    return "no";
  }

  //tak poszło jako solution;
  public static String isSortedAndHow(int[] array) {

    boolean isAscending = true;
    for (int i=0; i< array.length-1; i++){
      if(array[i]>array[i+1]){
        isAscending = false;
        break;
      }
    }
    if (isAscending){
      return "yes, ascending";
    }

    boolean isDescending = true;
    for (int i=0; i< array.length-1; i++){
      if(array[i]<array[i+1]){
        isDescending = false;
        break;
      }
    }
    if (isDescending){
      return "yes, descending";
    }

    return "no";
  }


}
