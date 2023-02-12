package practices.codewars.kyu7;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SimpleStringCharacters {
  public static int[] solve(String word) {
    int[] resultArr = new int[4];
    for (int i=0; i<word.length(); i++) {
      char character = word.charAt(i);
      if(Character.isUpperCase(character)) {
        resultArr[0]++;
      } else if(Character.isLowerCase(character)) {
        resultArr[1]++;
      } else if(Character.isDigit(character)) {
        resultArr[2]++;
      } else
        resultArr[3]++;
    }
    return resultArr;
  }

  public static void main(String[] args) {
    //System.out.println(Arrays.toString(solve("QWEqwer123456:.,")));
    System.out.println(Arrays.toString(solve("Codewars@codewars123.com")));
    System.out.println(Arrays.toString(solve("CbgA5<1d-tOwUZTS8yQ")));
    System.out.println(Arrays.toString(solve("P*K4%>mQUDaG$h=cx2?.Czt7!Zn16p@5H")));
    System.out.println(Arrays.toString(solve("RYT'>s&gO-.CM9AKeH?,5317tWGpS<*x2ukXZD")));
    System.out.println(Arrays.toString(solve("$Cnl)Sr<7bBW-&qLHI!mY41ODe")));
    System.out.println(Arrays.toString(solve("@mw>0=QD-iAx!rp9TaG?o&M%l$34L.nbft")));
  }
}
