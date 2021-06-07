package practices.codewars.kyu5;

import java.util.*;
import java.util.stream.Collectors;

public class FindingTheClosestMaximumValuesOfAFunctionToAnUpperLimit {

  //mine submitted:
  public static List<Long> maxValF(int[] range1, int[] range2, long hMax, int k) {
    // your code
    List<Long> result = new ArrayList<>();
    for(int x=range1[0] ; x<=range1[1] ; x++){
      for(int y=range2[0] ; y<=range2[1] ; y++){
        if (x==y) continue;
        long z = (long) Math.pow((long) ((x+y)/Math.abs(x-y)), Math.abs(x-y));
        if (z<=hMax) result.add(z);
      }
    }
    return result.stream()
        .distinct()
        .sorted((z1, z2)-> -z1.compareTo(z2))
        .limit(k)
        .sorted()
        .collect(Collectors.toList());
  }

  //mine improved:
  public static List<Long> maxValF_impr(int[] range1, int[] range2, long hMax, int k) {
    // your code
    Set<Long> set = new HashSet<>();
    for(int x=range1[0] ; x<=range1[1] ; x++){
      for(int y=range2[0] ; y<=range2[1] ; y++){
        if (x!=y) set.add((long) Math.pow((long) ((x+y)/Math.abs(x-y)), Math.abs(x-y)));
      }
    }
    List<Long> result = set.stream()
        .filter(i-> i<=hMax)
        .sorted()
        .collect(Collectors.toList());
    return result.subList(result.size() - k, result.size());
  }

  public static void main(String[] args) {
    System.out.println(maxValF(new int[]{1,10}, new int[]{1,10}, 500, 4));
    System.out.println(maxValF(new int[]{1,50}, new int[]{1,50}, 500, 4));
    System.out.println(maxValF(new int[]{1,50}, new int[]{1,50}, 1000, 5));
    System.out.println("***");
    System.out.println(maxValF_impr(new int[]{1,10}, new int[]{1,10}, 500, 4));
    System.out.println(maxValF_impr(new int[]{1,50}, new int[]{1,50}, 500, 4));
    System.out.println(maxValF_impr(new int[]{1,50}, new int[]{1,50}, 1000, 5));
  }
}
