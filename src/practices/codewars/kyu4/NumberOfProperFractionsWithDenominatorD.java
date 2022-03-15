package practices.codewars.kyu4;

import java.math.BigInteger;
import java.util.Set;
import java.util.TreeSet;

public class NumberOfProperFractionsWithDenominatorD {
  public static void main(String[] args) {
/*    System.out.println(getNoOfFractions(1));
    System.out.println(getNoOfFractions(2));
    System.out.println(getNoOfFractions(5));
    System.out.println(getNoOfFractions(15));
    System.out.println(getNoOfFractions(25));

    long startTime = System.currentTimeMillis();
    System.out.print(getNoOfFractions(100000000));
    System.out.println(" "+ (System.currentTimeMillis()-startTime)/1000d + "s");*/
/*    for (long i=Integer.MAX_VALUE; i>Integer.MAX_VALUE-100; i--) {
    //for (long i=1000000000; i<=1000000100; i++) {
    //for (long i=100; i<=150; i++) {
      if (isPrime(i)) {
        System.out.println(i);
      }
    }*/
/*    long startTime = System.currentTimeMillis();
    System.out.println(getPrimeDivisors(11*11)+" "+ (System.currentTimeMillis()-startTime)/1000d + "s");
    System.out.println(getPrimeDivisors(2*3*5*7*11)+" "+ (System.currentTimeMillis()-startTime)/1000d + "s");
    System.out.println(getNoOfFractions(2*3*5*7*11));
    System.out.println(getPrimeDivisors(43*47*53)+" "+ (System.currentTimeMillis()-startTime)/1000d + "s");
    System.out.println(getPrimeDivisors(43*47*530)+" "+ (System.currentTimeMillis()-startTime)/1000d + "s");
    System.out.println(getPrimeDivisors(1000000093L*152*10)+" "+ (System.currentTimeMillis()-startTime)/1000d + "s");
    System.out.println(getPrimeDivisors(4143553174L)+" "+ (System.currentTimeMillis()-startTime)/1000d + "s");
    System.out.println(getPrimeDivisors(9223372036854775807L)+" "+ (System.currentTimeMillis()-startTime)/1000d + "s");
    System.out.println(getPrimeDivisors(1003427533368395383L)+" "+ (System.currentTimeMillis()-startTime)/1000d + "s");
    System.out.println(getPrimeDivisors(4802419968590657004L)+" "+ (System.currentTimeMillis()-startTime)/1000d + "s");
    System.out.println(isPrime(400201664049221417L)+" "+ (System.currentTimeMillis()-startTime)/1000d + "s");
    System.out.println(getPrimeDivisors(1000000093L*1000000097*2*3)+" "+ (System.currentTimeMillis()-startTime)/1000d + "s");
    System.out.println(getPrimeDivisors(1000000093L)+" "+ (System.currentTimeMillis()-startTime)/1000d + "s");
    System.out.println(getPrimeDivisors(2147483563L*2147483549)+" "+ (System.currentTimeMillis()-startTime)/1000d + "s");
    System.out.println(getPrimeDivisors(2147483563L)+" "+ (System.currentTimeMillis()-startTime)/1000d + "s");
    System.out.println(getPrimeDivisors(Long.MAX_VALUE)+" "+ (System.currentTimeMillis()-startTime)/1000d + "s");
    System.out.println(getPrimeDivisors(Long.MAX_VALUE-1)+" "+ (System.currentTimeMillis()-startTime)/1000d + "s");
    System.out.println(getPrimeDivisors(Long.MAX_VALUE-2)+" "+ (System.currentTimeMillis()-startTime)/1000d + "s");
    System.out.println(getPrimeDivisors(Long.MAX_VALUE-4)+" "+ (System.currentTimeMillis()-startTime)/1000d + "s");
    System.out.println(getPrimeDivisors(9223372036854775783L)+" "+ (System.currentTimeMillis()-startTime)/1000d + "s");*/
    System.out.println(getNoOfFractions(2*3));
    System.out.println(getNoOfFractions(3*5));
    System.out.println(getNoOfFractions(2*3*5));
    System.out.println(getNoOfFractions(3*5*7));
    System.out.println(getNoOfFractions(5*7*11));
    System.out.println(getNoOfFractions(2*3*5*7));
    System.out.println(getNoOfFractions(2*3*5*13));
  }


  private static long getNoOfFractions(long denominator){
    long counter = 0;
    for (long numerator = 1; numerator <denominator; numerator++) {
      if (new BigInteger(""+numerator).gcd(new BigInteger(""+denominator)).equals(BigInteger.ONE)) {
        counter++;
      }
    }
    return counter;
  }

  private static Set<Long> getPrimeDivisors(long number){
    Set<Long> resultSet = new TreeSet<>();
    long remainder = number;
    if (remainder%2==0) resultSet.add(2L);
    while (remainder%2==0){
      remainder = remainder/2;
    }
    long divisor=3;
    long sqrt = (long) Math.sqrt(remainder);
    while (divisor<=sqrt){
      if (remainder % divisor == 0) {
        resultSet.add(divisor);
        remainder = remainder / divisor;
        sqrt = (long) Math.sqrt(remainder);
      } else {
        divisor = divisor + 2;
      }
    }
    if (remainder!=number) resultSet.add(remainder);
    return resultSet;
  }

  private static boolean isPrime(long number){
    if (number<2) return false;
    if (number==2) return true;
    if (number%2==0) return false;
    long maxSearch = (long) Math.sqrt(number);
    for (long n=3; n<=maxSearch; n=n+2) {
      if (number%n==0) return false;
    }
    return true;
  }
}
