package practices.codewars.kyu6;

import java.util.Arrays;

public class PureOddDigitsPrimes {

  public static long[] onlyOddDigPrimes(long n) {
    long[] result = new long[]{getCount(n), getTheSmaller(n), getTheLarger(n)};
    System.out.println(n + ": " + Arrays.toString(result));
    return result;
  }

  private static boolean isPrime(long num) {
    if (num<2) return false;
    if (num==2) return true;
    if (num%2==0) return false;
    for(long n=3; n<=Math.sqrt(num); n++){
      if (num%n == 0) return false;
    }
    return true;
  }

  private static boolean isPureOddDigit(long num) {
    String[] evenDigits = {"0", "2", "4", "6", "8"};
    for (String evenDigit : evenDigits) {
      if (String.valueOf(num).contains(evenDigit)) {
        return false;
      }
    }
    return true;
  }

  private static boolean isPrimePureOddDigit(long num){
    return isPureOddDigit(num) && isPrime(num);
  }

  private static long getCount(long num){
    long count = 0;
    for (long n=0; n<=num; n++){
      if (isPrimePureOddDigit(n)){
        count++;
      }
    }
    return count;
  }

  private static long getTheSmaller(long num){
    for (long n=num-1; n>0; n--){
      if (isPrimePureOddDigit(n)){
        return n;
      }
    }
    return 3;
  }

  private static long getTheLarger(long num){
    for (long n=num+1; n<Long.MAX_VALUE; n++){
      if (isPrimePureOddDigit(n)){
        return n;
      }
    }
    return num;
  }
}
