package practices.codewars.kyu5;

import java.util.stream.LongStream;

public class BuddyPairs {

  //mine submitted
  public static String buddy(long start, long limit) {
    // your code
    for (long n=start; n<=limit ; n++){
      long m=getAllDivisorsSum(n)-1;
      if (m>n && getAllDivisorsSum(m)-1==n) return String.format("(%s %s)", n, m);
    }
    return "Nothing";
  }
  private static long getAllDivisorsSum(long number){
    long sqrt = (long) Math.sqrt(number);
    return LongStream.rangeClosed(2, sqrt)
        .filter(i-> number%i==0)
        .map(x-> x+number/x)
        .sum()+1-(sqrt*sqrt==number ? sqrt : 0);
  }

  public static void main(String[] args) {
    System.out.println(buddy(46,52));
    System.out.println(buddy(381,4318));
    System.out.println(buddy(2382,3679));
    System.out.println(buddy(1071625,1103735));
    System.out.println(buddy(1,7791));
    System.out.println(buddy(210,3495));
    System.out.println(buddy(1048,3495));
    System.out.println(getAllDivisorsSum(320)-1);
    System.out.println(getAllDivisorsSum(441)-1);
    System.out.println(getAllDivisorsSum(100));
  }
}
