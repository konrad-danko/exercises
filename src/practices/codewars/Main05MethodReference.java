package practices.codewars;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main05MethodReference {

  public static void main(String[] args) {
    List<String> names = Arrays.asList("Wojtek", "Kasia", "Ania", "Maciek");

    printNames01(names);
    System.out.println();
    printNames02(names);
    System.out.println();
    printNames03(names);
    System.out.println();

    Consumer<List<String>> listConsumer01 = list-> printNames03(list);
    listConsumer01.accept(names);
    System.out.println();

    Consumer<List<String>> listConsumer02 = Main05MethodReference::printNames03;
    listConsumer02.accept(names);
  }

  public static void printNames01(List<String> list){
    for (String string: list) {
      System.out.println(string);
    }
  }

  public static void printNames02(List<String> list){
    list.forEach(item-> System.out.println(item));
  }

  public static void printNames03(List<String> list){
    list.forEach(System.out::println);
  }
}
