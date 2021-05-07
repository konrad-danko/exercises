package practices.codewars.kyu6;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseOrRotate {
  public static String revRot(String strng, int sz) {
    // your code
    return (strng==null || sz<=0 || strng.isEmpty() || sz>strng.length()) ?
        "" :
        IntStream.range(0, strng.length()/sz)
            .mapToObj(n -> revRotAChunk(strng.substring(n*sz, n*sz+sz)))
            .collect(Collectors.joining());
  }

  private static String revRotAChunk(String chunk){
    long sumOfCubes = chunk.chars()
        .mapToLong(Character::getNumericValue)
        .map(n -> n*n*n)
        .sum();

    return sumOfCubes %2 == 0 ?
        new StringBuilder(chunk).reverse().toString() :
        chunk.substring(1) + chunk.substring(0,1);
  }

  public static void main(String[] args) {
    System.out.println(revRot("123456779", 8));
  }
}
