package practices.codewars.kyu7;

public class HighestAndLowest {
  public static String highAndLow(String numbers) {
    String[] split = numbers.split(" ");
    int min = Integer.parseInt(split[0]);
    int max = Integer.parseInt(split[0]);
    for (String s: split) {
      int num = Integer.parseInt(s);
      max = Math.max(num, max);
      min = Math.min(num, min);
    }
    return max + " " + min;
  }
}
