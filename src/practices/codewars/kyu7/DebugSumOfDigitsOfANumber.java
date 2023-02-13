package practices.codewars.kyu7;

public class DebugSumOfDigitsOfANumber {
  public static int sumOfDigits(int n) {
    int sum = 0;
    String digits = n + "";
    for (int i = 0; i < digits.length(); i++) {
      sum += Integer.parseInt(digits.substring(i,i+1));
    }
    return sum;
  }
}
