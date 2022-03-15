package practices.codewars;

import java.util.*;
import java.util.stream.Collectors;

public class Main02 {
  public static void main(String[] args) {
/*    List<String> coloursList = Arrays.asList("red","red", "red","red","red","red","blue","blue", "green");
    System.out.println(getOdd(coloursList));
    System.out.println(addAbc(coloursList));*/

/*    List<String> namesList = Arrays.asList("name01", "name01", "name03", "name02",
        "name02", "name01", "name04");
    System.out.println(new HashSet<>(namesList));
    System.out.println(new TreeSet<>(namesList));

    String str1 = "7abc8";
    String str2 = "7abc";
    System.out.println(str1.compareTo(str2));

    Map<String, Long> collect = namesList.stream()
        .collect(Collectors.groupingBy(s->s, Collectors.counting()));
    System.out.println(collect);
    collect.entrySet().stream()
        .forEach(System.out::println);
    collect.entrySet().stream()
        .map(x-> x.getKey())
        .forEach(System.out::println);
    collect.entrySet().stream()
        .map(Map.Entry::getValue)
        .forEach(System.out::println);

    List<String> collect1 = namesList.stream()
        .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
        .entrySet().stream()
        .filter(x -> x.getValue() > 1)
        .map(Map.Entry::getKey)
        .collect(Collectors.toList());
    System.out.println(collect1);*/
/*    System.out.println(isPrime(1000000000000000007l));
    for (long number=0; number<=10; number++){
      if (isPrime(number)) System.out.println(number);
    }*/

/*    List<String> names = Arrays.asList("name01", "name01", "name03", "name02", "name02", "name01", "name04");
    Map<String, Long> map = names.stream()
        .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    System.out.println(map); //{name04=1, name03=1, name02=2, name01=3}*/

/*    for (int i=1; i<=100; i++ ) {
      if (i%3==0 && i%5==0) {
        System.out.println("FizzBuzz");
        continue;
      }
      if (i%3==0) {
        System.out.println("Fizz");
        continue;
      }
      if (i%5==0) {
        System.out.println("Buzz");
        continue;
      }
      System.out.println(i);
    }*/

    int a = 20;
    int b = 3;
    System.out.println((float)a/b);
  }

  private static boolean isPrime(long number){
    if (number<2) return false;
    if (number==2) return true;
    if (number%2==0) return false;
    long maxSearch = (long) Math.sqrt(number);
    for (long n=3; n<=maxSearch; n=n+2) {
      if (number%n==0) return false;
    }
    return true;
  }

  private static List<String> getOdd(List<String> sourceList){
    return sourceList.stream()
        .distinct()
        .filter(x -> sourceList.stream()
            .filter(s -> s.equals(x))
            .count() % 2 == 1)
        .collect(Collectors.toList());
  }
  private static List<String> addAbc(List<String> sourceList){
    return sourceList.stream()
        .map(s-> s + "abc")
        .collect(Collectors.toList());
  }
}
