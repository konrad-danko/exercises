package practices.codewars.kyu4;

import java.util.stream.IntStream;

public class BlockSequence {

  public static int solve(long n){
    int numSeq = getNumberOfSeq(n);
    n = n - getSeqLen(numSeq-1);

    int numWord = getNumberOfWord(n);
    n = n - getWordLen(numWord-1);

    return Integer.parseInt(""+(""+numWord).charAt((int) (n-1)));
  }

  private static int getNumberOfSeq(long n){
    int minNum = 1;
    int maxNum = 500000000;
    int number;

    while (maxNum - minNum>20) {
      number = (minNum + maxNum)/2;
      if (getSeqLen(number-1)<n && n<=getSeqLen(number)) {
        return number;
      }
      if (getSeqLen(number)<n) {
        minNum = number;
      } else {
        maxNum = number;
      }
    }
    for (int i = minNum; i<= maxNum; i++){
      if (getSeqLen(i-1)<n && n<=getSeqLen(i)) {
        return i;
      }
    }
    return 0;
  }
  private static int getNumberOfWord(long n){
    int minNum = 1;
    int maxNum = 500000000;
    int number;

    while (maxNum - minNum>20) {
      number = (minNum + maxNum)/2;
      if (getWordLen(number-1)<n && n<=getWordLen(number)) {
        return number;
      }
      if (getWordLen(number)<n) {
        minNum = number;
      } else {
        maxNum = number;
      }
    }
    for (int i = minNum; i<= maxNum; i++){
      if (getWordLen(i-1)<n && n<=getWordLen(i)) {
        return i;
      }
    }
    return 0;
  }

  private static long getSeqLen(long number){
    int numLen = ("" + number).length();
    return IntStream.range(1, numLen)
        .mapToLong(l-> (getWordLen((long) Math.pow(10, l-1))
            + getWordLen((long) Math.pow(10, l)-1))
            *9*((long) Math.pow(10, l-1))/2)
        .sum()
        + (getWordLen((long) Math.pow(10, numLen-1)) + getWordLen(number))
        * (number - (long) Math.pow(10, numLen-1) + 1)/2;
  }
  private static long getWordLen(long number){
    int numLen = ("" + number).length();
    return  IntStream.range(1, numLen)
        .mapToLong(l -> (9 * (long) Math.pow(10, l-1)) * l)
        .sum()
         + (number - (long) Math.pow(10, numLen-1) + 1) * numLen;
  }




  public static void main(String[] args) {
    System.out.println(solve(1L));
    System.out.println(solve(2L));
    System.out.println(solve(3L));
    System.out.println(solve(100L));
    System.out.println(solve(2100L));
    System.out.println(solve(3100L));
    System.out.println(solve(55L));
    System.out.println(solve(123456L));
    System.out.println(solve(123456789L));
    System.out.println(solve(999999999999999999L));
    System.out.println(solve(1000000000000000000L));
    System.out.println(solve(999999999999999993L));
  }
}
