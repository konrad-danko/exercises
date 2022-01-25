package practices.codewars.kyu7;

public class ExesAndOhs {
  public static boolean getXO (String str) {
    // Good Luck!!
    return str.toUpperCase()
        .chars()
        .filter(c-> (c==79 || c==88))
        .map(n-> n==79? 1: -1)
        .sum() == 0;
  }
}
