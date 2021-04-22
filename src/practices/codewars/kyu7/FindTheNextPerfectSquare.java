package practices.codewars.kyu7;

public class FindTheNextPerfectSquare {
  public static long findNextSquare(long sq) {
    long root = (long) Math.sqrt(sq);
    return Math.pow(root, 2) != sq ? -1 : (long) Math.pow(root + 1, 2);
  }
}
