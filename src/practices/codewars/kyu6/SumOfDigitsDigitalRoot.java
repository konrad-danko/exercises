package practices.codewars.kyu6;

public class SumOfDigitsDigitalRoot {

  public static int digital_root(int n) {
    int result = String.valueOf(n).chars()
        .map(i-> i-48)
        .sum();
    return result<10? result: digital_root(result);
  }
}
