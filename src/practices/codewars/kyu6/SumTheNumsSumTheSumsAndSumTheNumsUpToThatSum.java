package practices.codewars.kyu6;

import java.math.BigInteger;

public class SumTheNumsSumTheSumsAndSumTheNumsUpToThatSum {
  public static BigInteger sumOfSums(int n) {
    //Enter your code here
    BigInteger number = new BigInteger(String.valueOf(n));
    return getSumOfArithSeq(getSumOfArithSeq(number)
        .add(getSumOfSquares(number))
        .divide(BigInteger.TWO));
  }

  private static BigInteger getSumOfArithSeq(BigInteger number) {
    return BigInteger.ONE
        .add(number)
        .multiply(number)
        .divide(BigInteger.TWO);
  }

  private static BigInteger getSumOfSquares(BigInteger number) {
    return BigInteger.TWO.multiply(number.pow(3))
        .add(new BigInteger("3").multiply(number.pow(2)))
        .add(number)
        .divide(new BigInteger("6"));
  }
}
