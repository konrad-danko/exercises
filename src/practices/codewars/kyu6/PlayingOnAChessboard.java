package practices.codewars.kyu6;

public class PlayingOnAChessboard {

  public static String game(long n) {
    // your code
    String content = (n*n)%2==0 ? n*n/2 + "" : n*n + ", " + 2;
    return "[" + content + "]";
  }
}
