package practices.codewars.kyu4;

import java.util.ArrayList;
import java.util.List;

public class SquareIntoSquaresProtectTrees {

  public String decompose(long n) {
    List<String> numbersList = new ArrayList<>();
    for (long number = n-1; number>0; number--){
      if (isValidNumber(number, n*n, numbersList)){
        numbersList.add(String.valueOf(number));
        return String.join(" ", numbersList).trim();
      }
    }
    return null;
  }

  private boolean isValidNumber(long numberToCheck, long sumToCheck, List<String> numbersList){
    if (numberToCheck * numberToCheck == sumToCheck){
      return true;
    }
    long newSumToCheck = sumToCheck - numberToCheck * numberToCheck;
    long newNumberToCheck = (long) Math.min(Math.sqrt(newSumToCheck), numberToCheck-1);
    for (long number = newNumberToCheck; number>0; number--){
      if (isValidNumber(number, newSumToCheck, numbersList)){
        numbersList.add(String.valueOf(number));
        return true;
      }
    }
    return false;
  }
}
