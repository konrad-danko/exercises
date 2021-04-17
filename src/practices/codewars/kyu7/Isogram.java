package practices.codewars.kyu7;

public class Isogram {
  public static boolean isIsogram(String str) {
    return str.length() == str.toLowerCase().chars().distinct().count();
  }

  public static void main(String[] args) {
    String str = "asdfgo";
    System.out.println(isIsogram(str));
  }

}
