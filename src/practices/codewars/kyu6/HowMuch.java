package practices.codewars.kyu6;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HowMuch {

  //mine submitted
  public static String howmuch(int m, int n) {
    // your code
    return String.format("[%s]",
        IntStream.rangeClosed(Math.min(m, n), Math.max(m, n))
        .mapToObj(i-> (i%9==1 && i%7==2) ?
            String.format("[M: %s B: %s C: %s]", i, i/7, i/9) :
            "")
        .collect(Collectors.joining())
    );
  }

  //mine improved
  public static String howmuch_impr(int m, int n) {
    // your code
    return "[" +
        IntStream.rangeClosed(Math.min(m, n), Math.max(m, n))
            .filter(i-> (i%9==1 && i%7==2))
            .mapToObj(i-> String.format("[M: %s B: %s C: %s]", i, i/7, i/9))
            .collect(Collectors.joining())
        + "]";
  }

  public static void main(String[] args) {
    System.out.println(howmuch_impr(1, 100));
    System.out.println(howmuch_impr(2950,2950));
    System.out.println(howmuch_impr(1000,1100));
    System.out.println(howmuch_impr(10000,9950));
    System.out.println(howmuch_impr(0,200));
  }
}
