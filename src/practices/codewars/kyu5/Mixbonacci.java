package practices.codewars.kyu5;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mixbonacci {

  //mine submitted:
  public static BigInteger[] mixbonacci(String[] pattern, int length) {

    if (length==0 || pattern.length==0) return new BigInteger[0];

    List<Long> fibList = new ArrayList<>();
    fibList.add(0, 0L);
    fibList.add(1, 1L);
    for (int i=2 ; i<length ; i++){
      fibList.add(i, fibList.get(i-1) + fibList.get(i-2));
    }
    List<Long> padList = new ArrayList<>();
    padList.add(0, 1L);
    padList.add(1, 0L);
    padList.add(2, 0L);
    for (int i=3 ; i<length ; i++){
      padList.add(i, padList.get(i-2) + padList.get(i-3));
    }
    List<Long> jacList = new ArrayList<>();
    jacList.add(0, 0L);
    jacList.add(1, 1L);
    for (int i=2 ; i<length ; i++){
      jacList.add(i, jacList.get(i-1) + 2*jacList.get(i-2));
    }
    List<Long> pelList = new ArrayList<>();
    pelList.add(0, 0L);
    pelList.add(1, 1L);
    for (int i=2 ; i<length ; i++){
      pelList.add(i, 2*pelList.get(i-1) + pelList.get(i-2));
    }
    List<Long> triList = new ArrayList<>();
    triList.add(0, 0L);
    triList.add(1, 0L);
    triList.add(2, 1L);
    for (int i=3 ; i<length ; i++){
      triList.add(i, triList.get(i-1) + triList.get(i-2) + triList.get(i-3));
    }
    List<Long> tetList = new ArrayList<>();
    tetList.add(0, 0L);
    tetList.add(1, 0L);
    tetList.add(2, 0L);
    tetList.add(3, 1L);
    for (int i=4 ; i<length ; i++){
      tetList.add(i, tetList.get(i-1) + tetList.get(i-2) + tetList.get(i-3) + tetList.get(i-4));
    }

    List<List<Long>> allLists = new ArrayList<>();
    allLists.add(0, fibList);
    allLists.add(1, padList);
    allLists.add(2, jacList);
    allLists.add(3, pelList);
    allLists.add(4, triList);
    allLists.add(5, tetList);

    BigInteger[] result = new BigInteger[length];
    List<String> sequences = Arrays.asList("fib","pad","jac","pel","tri","tet");

    for (int resultIndex = 0; resultIndex<length ; resultIndex++) {
      String sequence = pattern[resultIndex%pattern.length];
      int indexOfSequence = sequences.indexOf(sequence);
      long resultItem = allLists.get(indexOfSequence).get(0);
      result[resultIndex] = new BigInteger(String.valueOf(resultItem));
      allLists.get(indexOfSequence).remove(0);
    }
    return result;
  }

  public static void main(String[] args) {
    String[] pattern = {"fib", "fib", "pel"};
    System.out.println(Arrays.toString(mixbonacci(pattern, 6)));
  }

}
