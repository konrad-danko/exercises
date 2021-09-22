package practices.codewars.kyu6;

public class SequencesAndSeries {
  public static long getScore(long n) {
    // do your magic here
    long tempValue = 0;
    long result = 0;
    for (long l=1; l<=n; l++) {
      result = l*50 + tempValue;
      tempValue = result;
    }
    return result;
  }
}
