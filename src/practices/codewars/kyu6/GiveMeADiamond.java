package practices.codewars.kyu6;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GiveMeADiamond {

  //mine submitted:
  public static String print(int n) {
    // TODO your code here
    if (n<1 || n%2==0) {
      return null;
    }
    StringBuilder sb = new StringBuilder();
    int i=1, k=2;
    while (i>0){
      String spaces = IntStream.range(0, (n-i)/2)
          .mapToObj(x-> " ")
          .collect(Collectors.joining());
      String stars = IntStream.range(0, i)
          .mapToObj(x-> "*")
          .collect(Collectors.joining());
      sb.append(spaces)
          .append(stars)
          .append("\n");
      k = i==n ? -k : k;
      i = i+k;
    }
    return sb.toString();
  }

  //clever:
  public static String print_cl(int n) {
    if (n % 2  == 0 || n <= 0) {return null;}
    StringBuilder expected = new StringBuilder();
    for (int i = 1; i <= n; i+=2) {
      expected.append(" ".repeat((n - i) / 2) + "*".repeat(i) + "\n");
    }
    for (int i = n - 2; i >= 1; i-=2) {
      expected.append(" ".repeat((n - i) / 2) + "*".repeat(i) + "\n");
    }
    return expected.toString();

  }

  public static void main(String[] args) {
    System.out.println(print_cl(2));
    System.out.println(print_cl(-1));
    System.out.println(print_cl(1));
    System.out.println(print_cl(3));
    System.out.println(print_cl(5));
  }

}
