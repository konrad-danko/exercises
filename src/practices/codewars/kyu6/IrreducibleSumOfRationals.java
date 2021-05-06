package practices.codewars.kyu6;

import java.math.BigInteger;
import java.util.Arrays;

public class IrreducibleSumOfRationals {

  //mine improved
  public static String sumFracts_impr(int[][] l) {
    if(l==null || l.length==0) return null;

    int denominator = Arrays.stream(l)
        .mapToInt(i-> i[1])
        .reduce(1, (a, b)-> a * b / BigInteger.valueOf(a).gcd(BigInteger.valueOf(b)).intValue());

    int numerator = Arrays.stream(l)
        .mapToInt(i-> denominator/i[1]*i[0])
        .sum();

    int divisor = BigInteger.valueOf(denominator).gcd(BigInteger.valueOf(numerator)).intValue();

    return denominator==divisor ?
        String.valueOf(numerator/divisor) :
        String.format("[%d, %d]", numerator/divisor, denominator/divisor);
  }



  //mine submitted
  public static String sumFracts(int[][] l) {
    // your code
    if (l==null || l.length==0){
      return null;
    }

    int denominator = 1;
    for (int i=0 ; i<l.length ; i++){
      denominator = denominator * l[i][1] / getMaxDivisor(denominator, l[i][1]);
    }

    int numerator = 0;
    for (int i=0 ; i<l.length ; i++){
      numerator = numerator + denominator / l[i][1] * l[i][0];
    }

    int maxDivisor = getMaxDivisor(numerator, denominator);

    return denominator/maxDivisor==1?
        "" + numerator/maxDivisor :
        "[" + numerator/maxDivisor + ", " + denominator/maxDivisor + "]";
  }

  private static int getMaxDivisor(int a, int b){
    int max = Math.max(a, b);
    int min = Math.min(a, b);
    return max%min==0 ? min : getMaxDivisor(min, max%min);
  }

  // best practice, clever
  public static String sumFracts_bp_cl(int[][] l) {
    if (l.length == 0) return null;

    final int D = Arrays.stream(l).mapToInt(ar -> ar[1]).reduce(1, (a, b) -> a * b);
    final int N = Arrays.stream(l).mapToInt(ar -> ar[0] * D / ar[1]).sum();

    int gcd = BigInteger.valueOf(D).gcd(BigInteger.valueOf(N)).intValue();
    return (D == gcd) ? String.valueOf(N / D) : String.format("[%d, %d]", N / gcd, D / gcd);
  }


  public static void main(String[] args) {
    System.out.println(sumFracts_impr(new int[][] { {1,2}, {2,9}, {3,18}, {4,24}, {6,48} }));
    System.out.println(sumFracts_impr(new int[][] { {1, 2}, {1, 3}, {1, 4} }));
    System.out.println(sumFracts_impr(new int[][] { {1, 3}, {5, 3} }));
    System.out.println(sumFracts_impr(new int[][] {}));
    System.out.println(sumFracts_impr(null));
  }
}
