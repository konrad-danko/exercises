package practices.codewars.kyu8;

public class AbbreviateTwoWords {
  public static String abbrevName(String name) {
    int indexOfSpace = name.indexOf(" ");
    String nameCapital = name.toUpperCase();
    return nameCapital.substring(0,1) + "." + nameCapital.substring(indexOfSpace+1, indexOfSpace+2);
  }
}
