package practices.codewars.kyu6;

import java.util.Arrays;
import java.util.stream.Collectors;

public class EncryptThis {
  public static String encryptThis(String text) {
    // Implement me! :)
    if(text==null || text.length()==0) {
      return "";
    }
    return Arrays.stream(text.split(" "))
        .map(EncryptThis::encryptSingleWord)
        .collect(Collectors.joining(" "));
  }

  private static String encryptSingleWord(String word) {
    String firstLetterAsASCII = String.valueOf((int) word.charAt(0));
    if (word.length()<3){
      return firstLetterAsASCII + word.substring(1);
    }
    return firstLetterAsASCII +
        word.charAt(word.length()-1) +
        word.substring(2, word.length()-1) +
        word.charAt(1);
  }

  public static void main(String[] args) {
    System.out.println(encryptThis("Hello"));
    System.out.println(encryptThis("good"));
    System.out.println(encryptThis("hello world"));
    System.out.println(encryptThis("A wise old owl lived in an oak"));
  }
}
