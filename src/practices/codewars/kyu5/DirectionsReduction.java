package practices.codewars.kyu5;

public class DirectionsReduction {

  public static String[] dirReduc(String[] arr) {
    // Your code here.
    String resultStr = String.join(" ", arr);
    int resultStrLength = resultStr.length();
    while (true){
      resultStr = resultStr
          .replaceAll("NORTH SOUTH", "")
          .replaceAll("SOUTH NORTH", "")
          .replaceAll("WEST EAST", "")
          .replaceAll("EAST WEST", "")
          .replaceAll("[ ]+", " ")
          .trim();
      if (resultStr.length() == resultStrLength) break;
      resultStrLength = resultStr.length();
    }
    return resultStrLength==0 ? new String[0] : resultStr.split(" ");
  }
}
