package practices.codewars.kyu7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryArrayToNumber {

  //to poszło jako solution
  public static int ConvertBinaryArrayToInt_v1(List<Integer> binary) {
    int index = binary.size()-1;
    int sum = 0;
    int power = 0;
    while (index>=0) {
      sum = (int) (sum + binary.get(index)*Math.pow(2.0, power));
      index--;
      power++;
    }
    return sum;
  }

  //to jest fajniejsze
  public static int ConvertBinaryArrayToInt(List<Integer> binary) {
    String str = binary.stream()
        .map(String::valueOf)
        .collect(Collectors.joining());
    return Integer.parseInt(str,2);
  }

  public static void main(String[] args) {
    System.out.println(ConvertBinaryArrayToInt(Arrays.asList(0,0,0,1)));
    System.out.println(ConvertBinaryArrayToInt(Arrays.asList(0,0,1,0)));
    System.out.println(ConvertBinaryArrayToInt(Arrays.asList(0,1,0,1)));
    System.out.println(ConvertBinaryArrayToInt(Arrays.asList(1,0,0,1)));
    System.out.println(ConvertBinaryArrayToInt(Arrays.asList(0,0,1,0)));
    System.out.println(ConvertBinaryArrayToInt(Arrays.asList(0,1,1,0)));
    System.out.println(ConvertBinaryArrayToInt(Arrays.asList(1,1,1,1)));
    System.out.println(ConvertBinaryArrayToInt(Arrays.asList(1,0,1,1)));
  }
}
