package practices.codewars.kyu7;

public class StringEndsWith {
  public static boolean solution(String str, String ending) {
    int strLength = str.length();
    int endingLength = ending.length();
    return endingLength <= strLength && str.substring(strLength-endingLength).equals(ending);
  }
}
