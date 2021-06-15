package practices.codewars.kyu5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumbersAndItsReversalHavingSamePrimeFactors {

  //mine submitted:
  public static int[] sameFactRev(int nMax) {
    return IntStream.rangeClosed(10,nMax)
        .filter(i-> !(""+ i).equals(new StringBuilder(""+ i).reverse().toString()))
        .filter(i-> getUniquePrimeFactors(i)
            .equals(getUniquePrimeFactors(Integer
                .parseInt(new StringBuilder(""+i).reverse().toString()))))
        .toArray();
  }
  private static String getUniquePrimeFactors(int number){
    Set<Integer> setOfPrimeFactors = new HashSet<>();
    while (number%2==0) {
      setOfPrimeFactors.add(2);
      number=number/2;
    }
    for (int i=3; i<=Math.sqrt(number); i=i+2) {
      while (number%i==0) {
        setOfPrimeFactors.add(i);
        number=number/i;
      }
    }
    setOfPrimeFactors.add(number);
    return setOfPrimeFactors.stream()
        .sorted()
        .map(x-> ""+x)
        .collect(Collectors.joining("-"));
  }

  public static void main(String[] args) {
    int[] array = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000, 9000, 10000};
    for (int i: array){
      System.out.println(i + ": " + Arrays.toString(sameFactRev(i)));
    }
    System.out.println(1000000 + ": " + Arrays.toString(sameFactRev(1000000)));
  }
}
