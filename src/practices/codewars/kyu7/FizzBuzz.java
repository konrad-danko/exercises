package practices.codewars.kyu7;

import java.util.stream.IntStream;

public class FizzBuzz {
  public static String[] fizzBuzz(int n) {
    return IntStream.rangeClosed(1, n)
        .mapToObj(number-> getItem(number))
        .toArray(String[]::new);
  }

  private static String getItem(int number){
    if(number%3==0 && number%5==0) {
      return "FizzBuzz";
    }
    if(number%5==0) {
      return "Buzz";
    }
    if(number%3==0) {
      return "Fizz";
    }
    return String.valueOf(number);
  }
}
