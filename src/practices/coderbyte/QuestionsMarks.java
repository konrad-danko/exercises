package practices.coderbyte;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QuestionsMarks {
  public static void main(String[] args) {


    System.out.println(questionsMarks("arrb6???4xxbl5???eee5"));
    System.out.println(questionsMarks("aa6?9"));
    System.out.println(questionsMarks("5??aaaaaaaaaaaaaaaaaaa?5?5"));
    System.out.println(questionsMarks("mbbv???????????4??????ddsdsdcc9?"));
    System.out.println();
    System.out.println(questionsMarks("arrb6???4xxbl5???eee5"));
    System.out.println(questionsMarks("aaaaaaarrrrr??????"));
    System.out.println(questionsMarks("9???1???9???1???9"));
    System.out.println(questionsMarks("9???1???9??1???9"));
    System.out.println();
    System.out.println(questionsMarks("5??aaaaaaaaaaaaaaaaaaa?5?a??5"));
    System.out.println(questionsMarks("mbbv???????????4??????ddsdsdcc9?"));
  }

  private static String questionsMarks(String str){
    str = str.toLowerCase().replaceAll("[a-z]", "");
    String result = "false";
    Pattern pattern = Pattern.compile("\\d");
    Matcher matcher = pattern.matcher(str);

    if (!matcher.find()) return result;
    int startIndex = matcher.start();
    while (matcher.find()) {
      int endIndex = matcher.start();
      int startValue = Integer.parseInt(""+str.charAt(startIndex));
      int endValue = Integer.parseInt(""+str.charAt(endIndex));

      if (startValue+endValue==10 && endIndex-startIndex==4) result="true";
      if (startValue+endValue==10 && endIndex-startIndex!=4) return "false";
      startIndex = endIndex;
    }
    return result;
  }

}
