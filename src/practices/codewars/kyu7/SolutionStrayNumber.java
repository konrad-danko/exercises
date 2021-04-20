package practices.codewars.kyu7;

import java.util.Arrays;

public class SolutionStrayNumber {

  //mine
  static int stray(int[] numbers) {
    Arrays.sort(numbers);
    if(numbers[0]==numbers[1]){
      return numbers[numbers.length-1];
    }
    return numbers[0];
  }
  //best practice
  static int stray_BP(int[] numbers) {
    if (numbers[0] != numbers[1] && numbers[0] != numbers[2]) {
      return numbers[0];
    }
    for (int i : numbers) {
      if (i != numbers[0]) {
        return i;
      }
    }
    return 0;
  }
  //clever
  static int stray_Cl(int[] numbers) {
    return Arrays.stream(numbers).reduce(0, (a, b) -> a ^ b);
  }

  public static void main(String[] args) {
    int[] array = {1, 5, 1, 1, 1, };
    System.out.println(stray(array));
  }
}
