package practices.codewars.kyu7;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CountTheDigit {

  //mine
  public static int nbDig(int n, int d) {
    return IntStream.range(0, n+1)
        .map(i->i*i)
        .mapToObj(String::valueOf)
        .collect(Collectors.joining())
        .replaceAll("[^"+d+"]", "")
        .length();
  }

  //mine improved
  public static int nbDig_impr(int n, int d) {
    return IntStream.range(0, n+1)
        .mapToObj(i-> String.valueOf(i*i))
        .map(s-> s.replaceAll("[^"+d+"]", ""))
        .collect(Collectors.joining())
        .length();
  }

  //mine clever
  public static int nbDig_cl(int n, int d) {
    return (int) IntStream
        .rangeClosed(0, n)
        .map(i -> i * i)
        .flatMap(i -> String.valueOf(i).chars())
        .mapToObj(i -> (char)i)
        .mapToInt(Character::getNumericValue)
        .filter(i -> i == d)
        .count();
  }


  public static void main(String[] args) {
    System.out.println(nbDig(10, 1));
    System.out.println(nbDig(25, 1));
    System.out.println(nbDig(5750, 0));
    System.out.println(nbDig(11011, 2));
    System.out.println(nbDig(12224, 8));
    System.out.println(nbDig(11549, 1));
    System.out.println(nbDig_impr(10, 1));
    System.out.println(nbDig_impr(25, 1));
    System.out.println(nbDig_impr(5750, 0));
    System.out.println(nbDig_impr(11011, 2));
    System.out.println(nbDig_impr(12224, 8));
    System.out.println(nbDig_impr(11549, 1));
  }
}
