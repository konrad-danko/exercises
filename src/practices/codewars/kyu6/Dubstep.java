package practices.codewars.kyu6;

public class Dubstep {
  //mine submitted + best practice + clever
  public static String SongDecoder (String song) {
    // Your code is here...
    return song.replaceAll("(WUB)+", " ").trim();
  }
}
