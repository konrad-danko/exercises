package practices.codewars.kyu6;

public class MexicanWave {
  public static String[] wave(String str) {
    // Your code here
    if (str.replaceAll(" ", "").length()==0) return new String[] {};
    StringBuilder resultSb = new StringBuilder();
    for (int index=0; index<str.length(); index++) {
      if (str.charAt(index)==' ') continue;
      resultSb.append("-")
          .append(str, 0, index)
          .append(str.substring(index,index+1).toUpperCase())
          .append(str.substring(index+1));
    }
    return resultSb.substring(1).split("-");
  }
}
