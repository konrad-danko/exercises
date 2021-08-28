package practices.codewars.kyu6;

public class CountingDuplicates {
  public static int duplicateCount(String text) {
    // Write your code here
    int counter = 0;
    for (int charCode=48; charCode<=90; charCode++) {
      int finalCharCode = charCode;
      long count = text.toUpperCase().chars()
          .filter(c -> c == finalCharCode)
          .count();
      if (count>1) counter++;
    }
    return counter;
  }

  public static void main(String[] args) {
    String text = "aabBcde";
    System.out.println(text + ": " + duplicateCount(text));
  }
}
