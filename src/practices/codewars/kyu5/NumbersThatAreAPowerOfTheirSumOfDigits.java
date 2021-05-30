package practices.codewars.kyu5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersThatAreAPowerOfTheirSumOfDigits {

  public static long powerSumDigTerm(int n) {
    // your code
    List<Long> listOfNumbers = new ArrayList<>();

    for (int power=2 ; power<64 ; power++){
      for (int number=1; number<=200 ; number++){
        long numberPowered = (long) Math.pow(number, power);
        int sumOfDigits = String.valueOf(numberPowered)
            .chars()
            .map(Character::getNumericValue)
            .sum();
        if (sumOfDigits == number){
          listOfNumbers.add(numberPowered);
        }
      }
    }

    return listOfNumbers.stream()
        .distinct()
        .sorted()
        .collect(Collectors.toList())
        .get(n);
  }


  public static void main(String[] args) {
    for (int i=0 ; i<=33 ; i++){
      System.out.println(i + ": " + powerSumDigTerm(i));
    }
    System.out.println("Lon max: " + Long.MAX_VALUE);
  }
}
