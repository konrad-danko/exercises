package practices.codewars.kyu7;

public class Ch4113ng3 {
  public static String nerdify(String txt){
    return txt
        .replaceAll("[aA]", "4")
        .replaceAll("[eE]", "3")
        .replaceAll("[l]", "1");
  }
}
