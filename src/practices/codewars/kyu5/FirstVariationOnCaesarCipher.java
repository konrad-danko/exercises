package practices.codewars.kyu5;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FirstVariationOnCaesarCipher {
  //mine submitted:
  public static List<String> movingShift(String s, int shift) {
    char[] charArray = s.toCharArray();
    String encodedStr = IntStream.range(0, charArray.length)
        .mapToObj(i -> ""+getEncoded(charArray[i], i +shift))
        .collect(Collectors.joining());
    int[] splitIndexes = IntStream.rangeClosed(0,5)
        .map(i-> (int) Math.min(i*Math.ceil(encodedStr.length()/5.0), encodedStr.length()))
        .toArray();
    return IntStream.range(0,5)
        .mapToObj(i->encodedStr.substring(splitIndexes[i], splitIndexes[i+1]))
        .collect(Collectors.toList());
  }
  private static char getEncoded (char c, int shift) {
    int param = 0;
    if ((""+c).matches("[a-z]")) param = 97;
    if ((""+c).matches("[A-Z]")) param = 65;
    return param==0 ? c : (char)(((int)c- param +shift)%26+ param);
  }
  public static String  demovingShift(List<String> s, int shift) {
    char[] charArray = s.stream()
        .reduce("", (a, b)-> ""+a+b)
        .toCharArray();
		return IntStream.range(0, charArray.length)
        .mapToObj(i -> ""+getDecoded(charArray[i], i +shift))
        .collect(Collectors.joining());
  }
  private static char getDecoded (char c, int shift) {
    int param = 0;
    if ((""+c).matches("[a-z]")) param = 97;
    if ((""+c).matches("[A-Z]")) param = 65;
    return param==0 ? c : (char)(((int)c- param -shift%26+26)%26+ param);
  }

  public static void main(String[] args) {
    String qqq = "abcdeabcdeabcdeabcdeabcde";
    System.out.println(qqq);
    List<String> www = movingShift(qqq, 1);
    System.out.println(www);
    System.out.println(demovingShift(www,1));
  }
}
