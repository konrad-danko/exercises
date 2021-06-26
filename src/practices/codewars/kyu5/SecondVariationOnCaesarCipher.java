package practices.codewars.kyu5;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SecondVariationOnCaesarCipher {
  public static List<String> encodeStr(String s, int shift) {
    // your code
    char[] charArray = s.toCharArray();
    String prefix = "" + Character.toLowerCase(charArray[0]) + getEncoded(Character.toLowerCase(charArray[0]), shift);
    String encodedStr = prefix + IntStream.range(0, charArray.length)
        .mapToObj(i -> ""+getEncoded(charArray[i], shift))
        .collect(Collectors.joining());
    int[] splitIndexes = IntStream.rangeClosed(0,5)
        .map(i-> (int) Math.min(i*Math.ceil(encodedStr.length()/5.0), encodedStr.length()))
        .toArray();
    return IntStream.range(0,5)
        .mapToObj(i->encodedStr.substring(splitIndexes[i], splitIndexes[i+1]))
        .filter(str-> str.length()!=0)
        .collect(Collectors.toList());
  }
  private static char getEncoded (char c, int shift) {
    int param = 0;
    if ((""+c).matches("[a-z]")) param = 97;
    if ((""+c).matches("[A-Z]")) param = 65;
    return param==0 ? c : (char)(((int)c- param +shift)%26+ param);
  }

  public static String decode(List<String> s) {
    // your code
    int shift = (String.join("", s).charAt(1) - String.join("", s).charAt(0)) % 26;
    char[] charArray = s.stream()
        .reduce("", (a, b)-> ""+a+b)
        .toCharArray();
    return IntStream.range(2, charArray.length)
        .mapToObj(i -> ""+getDecoded(charArray[i], shift))
        .collect(Collectors.joining());
  }
  private static char getDecoded (char c, int shift) {
    int param = 0;
    if ((""+c).matches("[a-z]")) param = 97;
    if ((""+c).matches("[A-Z]")) param = 65;
    return param==0 ? c : (char)(((int)c- param -shift%26+26)%26+ param);
  }
}
