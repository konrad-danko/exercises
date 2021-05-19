package practices.codewars.kyu6;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BinaryToTextASCIIConversion {

  //mine submitted:
  public static String binaryToText(String binary) {
    return IntStream.range(0, binary.length()/8)
        .mapToObj(x-> binary.substring(x*8, (x+1)*8))
        .mapToInt(x-> Integer.parseInt(x, 2))
        .mapToObj(x-> String.valueOf((char)x))
        .collect(Collectors.joining());
  }

  //best practice  + clever
  public static String binaryToText_bp_cl(String binary) {
    StringBuilder value = new StringBuilder();
    for (int i=0; i<binary.length(); i=i+8){
      value.append((char) Integer.parseInt(binary.substring(i, i + 8),2));
    }
    return value.toString();
  }

  public static void main(String[] args) {
    System.out.println(binaryToText("0100100001100101011011000110110001101111"));
  }
}
