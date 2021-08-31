package practices.codewars.kyu4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HowManyNumbersIII {

  public static List<Long> findAll(final int sumDigits, final int numDigits) {
    // Your code here!!
    List<Long> numbers = new ArrayList<>();
    List<Integer> digits = new ArrayList<>();
    generateNumbers(numbers, 0, digits, sumDigits, numDigits);
    List<Long> resultList = new ArrayList<>();
    if (numbers.size()>0) {
      resultList.add(0, (long) numbers.size());
      resultList.add(1, numbers.get(0));
      resultList.add(2, numbers.get(numbers.size()-1));
    }
    return resultList;
  }

  private static void generateNumbers(List<Long> numbList, int indexDigList, List<Integer> digList, int sumDigits, int numDigits){
    int startingDigit = indexDigList==0 ? 1 : digList.get(indexDigList-1);
    for (int digit=startingDigit; digit<=9; digit++) {
      if (digList.size()-1<indexDigList) {
        digList.add(indexDigList, digit);
      } else {
        digList.set(indexDigList, digit);
      }
      int sum = digList.stream().mapToInt(x->x).sum();
      if (sum>sumDigits) break;
      if (indexDigList != numDigits-1) {
        generateNumbers(numbList, indexDigList+1, digList, sumDigits, numDigits);
      } else {
        if (sum == sumDigits) {
          String str = digList.stream()
              .map(x-> ""+x)
              .collect(Collectors.joining());
          numbList.add(Long.parseLong(str));
        }
      }
    }
    digList.set(indexDigList, 0);
  }

/*  private static void generateWith4(List<Long> numbers, int sumOfDigits){
    for (int i0=1; i0<=9; i0++) {
      for (int i1=i0; i1<=9; i1++) {
        if (i0+i1>sumOfDigits) break;
        for (int i2=i1; i2<=9; i2++) {
          if (i0+i1+i2>sumOfDigits) break;
          for (int i3=i2; i3<=9; i3++) {
            if (i0+i1+i2+i3>sumOfDigits) break;
            if (i0+i1+i2+i3 == sumOfDigits) {
              numbers.add(Long.parseLong(""+i0+i1+i2+i3));
            }
          }
        }
      }
    }
  }*/

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    System.out.println(findAll(90, 17));
    long endTime = System.currentTimeMillis();
    System.out.println("Time: " + (endTime-startTime));
  }
}
