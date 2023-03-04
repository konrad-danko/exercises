package practices.codewars.kyu6;

public class PrimeCycles {

  private static final long[] PRIMES = {1, 2, 3, 5, 7, 11, 13, 17, 19, 23};

  public static long findMax(long n){
    long result = n;
    //not sure when to stop this checking but 20 times should be fine :)
    for (int i=0; i<20 ; i++) {
      n = getProductOfDigits(n);
      result = Math.max(n, result);
    }
    return result;
  }

  private static long getProductOfDigits (long number){
    return String.valueOf(number)
        .chars()
        .map(i-> i-48)
        .mapToLong(j-> PRIMES[j])
        .reduce(1, (n, k)-> n*k);
  }
}
