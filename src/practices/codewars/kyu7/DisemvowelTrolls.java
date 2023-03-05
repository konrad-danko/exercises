package practices.codewars.kyu7;

public class DisemvowelTrolls {
  public static String disemvowel(String str) {
    return str.replaceAll("[AaEeIiOoUuWw]", "");
  }
}
