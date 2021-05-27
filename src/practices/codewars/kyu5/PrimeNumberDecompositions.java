package practices.codewars.kyu5;

import java.util.*;

public class PrimeNumberDecompositions {

  //mine submitted:
  public static Long[] getAllPrimeFactors(long n) {
    if (n==1){
      return new Long[] {1L};
    }
    List<Long> listOfLongs = new ArrayList<>();
    long divisor = 2;
    while(n>1){
      if (n%divisor == 0) {
        listOfLongs.add(divisor);
        n = n/divisor;
      } else {
        divisor++;
      }
    }
    return listOfLongs.toArray(Long[]::new);
  }
  public static Long[][] getUniquePrimeFactorsWithCount(long n) {

    Long[] allPrimeFactors = getAllPrimeFactors(n);

    Long[] longs = Arrays.stream(allPrimeFactors)
        .distinct()
        .toArray(Long[]::new);

    Long[] powers = new Long[longs.length];
    int index = 0;
    for (Long l: longs) {
      powers[index] = Arrays.stream(allPrimeFactors)
          .filter(x-> l==x)
          .count();
      index++;
    }

    Long[][] result = new Long[2][];
    result[0] = longs;
    result[1] = powers;
    return result;
  }
  public static Long[] getPrimeFactorPotencies(long n) {
    Long[][] uniquePrimeFactorsWithCount = getUniquePrimeFactorsWithCount(n);

    int size = uniquePrimeFactorsWithCount[0].length;
    Long[] result = new Long[size];
    for (int i = 0 ; i<size ; i++){
      result[i] = (long) Math.pow(uniquePrimeFactorsWithCount[0][i], uniquePrimeFactorsWithCount[1][i]);
    }
    return result;
  }


  //best practices:
  public static Long[] getAllPrimeFactors_bp(long num) {
    ArrayList<Long> result = new ArrayList<>();
    for (long prime = 2; prime <= num; prime++)
      for (; num % prime == 0; num /= prime)
        result.add(prime);
    return result.toArray(new Long[result.size()]);
  }
  public static Long[][] getUniquePrimeFactorsWithCount_bp(long num) {
    Long[] primeF = getAllPrimeFactors(num);
    Set<Long> set = new HashSet<Long>(Arrays.asList(primeF));
    Long[][] result = new Long[2][set.size()];
    result[0] = set.toArray(new Long[set.size()]);
    for (int i = 0; i < result[0].length; i++)
      result[1][i] = (long) Collections.frequency(Arrays.asList(primeF), result[0][i]);
    return result;
  }
  public static Long[] getPrimeFactorPotencies_bp(long num) {
    Long[][] primeFC = getUniquePrimeFactorsWithCount(num);
    Long[] result = new Long[primeFC[0].length];
    for (int i = 0; i < primeFC[0].length; i++)
      result[i] = (long) Math.pow(primeFC[0][i], primeFC[1][i]);
    return result;
  }

  public static void main(String[] args) {
    System.out.println(Arrays.toString(getAllPrimeFactors(0)));
    System.out.println(Arrays.toString(getAllPrimeFactors(1)));
    System.out.println(Arrays.toString(getAllPrimeFactors(2)));
    System.out.println(Arrays.toString(getAllPrimeFactors(17)));
    System.out.println(Arrays.toString(getAllPrimeFactors(210)));
    System.out.println(Arrays.toString(getAllPrimeFactors(1000)));
    System.out.println(Arrays.toString(getAllPrimeFactors(1350)));
    System.out.println("****");
    long n = 100;
    System.out.println(Arrays.toString(getAllPrimeFactors(n)) + " " +
        Arrays.deepToString(getUniquePrimeFactorsWithCount(n)) + " " +
        Arrays.toString(getPrimeFactorPotencies(n)));
    n = 135;
    System.out.println(Arrays.toString(getAllPrimeFactors(n)) + " " +
        Arrays.deepToString(getUniquePrimeFactorsWithCount(n)) + " " +
        Arrays.toString(getPrimeFactorPotencies(n)));
    n = 45*7*11;
    System.out.println(Arrays.toString(getAllPrimeFactors(n)) + " " +
        Arrays.deepToString(getUniquePrimeFactorsWithCount(n)) + " " +
        Arrays.toString(getPrimeFactorPotencies(n)));

  }
}
