package practices.codewars.kyu6;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordA10nAbbreviation {
  public String abbreviate(String string) {
    // ...
    System.out.println(string);
    Pattern pattern = Pattern.compile("[a-zA-Z]+");
    Matcher matcher = pattern.matcher(string);
    return matcher.replaceAll(mr-> getAbbreviation(mr.group()));
  }

  private static String getAbbreviation(String str){
    int strLength = str.length();
    return strLength<=3?
        str:
        "" + str.charAt(0) + (strLength-2) + str.charAt(strLength-1);
  }
}
