package practices.codewars.kyu7;

import java.util.stream.LongStream;

public class SumOfCubes {
  public static long sumCubes(long n) {
    //put your code here :D
    return LongStream.rangeClosed(1,n)
        .map(i-> i*i*i)
        .sum();
  }
}
