package practices.codewars.kyu6;

import java.util.*;
import java.util.stream.IntStream;

public class DeleteOccurrencesOfAnElementIfItOccursMoreThanNTimes {

  //clever:
  public static int[] deleteNth_Cl(int[] elements, int maxOccurrences) {
    Map<Integer, Integer> occurrence = new HashMap<>();
    return IntStream.of(elements)
        .filter(motif -> occurrence.merge(motif, 1, Integer::sum) <= maxOccurrences)
        .toArray();
  }

  //mine submitted:
  public static int[] deleteNth(int[] elements, int maxOccurrences) {
    //Code here:
    System.out.println(Arrays.toString(elements) + ", " + maxOccurrences);
    Map<Integer, Integer> countRegister = new HashMap<>();
    Arrays.stream(elements).forEach(i-> countRegister.put(i,0));

    List<Integer> resultList = new ArrayList<>();
    for (int item : elements) {
      int countOfItems = countRegister.get(item);
      if (countOfItems < maxOccurrences){
        resultList.add(item);
        countRegister.put(item, ++countOfItems);
      }
    }
    return resultList.stream().mapToInt(x-> x).toArray();
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(deleteNth( new int[] { 20, 37, 20, 21 }, 1)));
    System.out.println(Arrays.toString(deleteNth(new int[] { 1, 1, 3, 3, 7, 2, 2, 2, 2 }, 3)));
    System.out.println(Arrays.toString(deleteNth(new int[] { 1, 2, 3, 1, 1, 2, 1, 2, 3, 3, 2, 4, 5, 3, 1 }, 3)));
  }
}
