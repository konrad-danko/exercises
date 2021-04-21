package practices.codewars.kyu7;

public class FixStringCase {
  public static String solve(final String str) {
    int lowerCaseCounter = (int) str.chars().filter(Character::isLowerCase).count();
    return lowerCaseCounter * 2 >= str.length() ? str.toLowerCase() : str.toUpperCase();
  }

  public static void main(String[] args) {
    System.out.println(solve("kwTdaQqGosDCcEvPMOKhgTW"));
  }
}
