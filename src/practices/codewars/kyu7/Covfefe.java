package practices.codewars.kyu7;

public class Covfefe {
  public static String covfefe(String tweet) {
    return tweet.contains("coverage")?
        tweet.replaceAll("coverage", "covfefe"):
        tweet + " covfefe";
  }
}
