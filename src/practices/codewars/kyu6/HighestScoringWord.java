package practices.codewars.kyu6;

public class HighestScoringWord {
  public static String high(String s) {
    // Your code here...
    String resultWord = "";
    int highestValue = 0;
    for (String word: s.split(" ")){
      int wordValue = word.chars().map(x-> x-96).sum();
      if (wordValue > highestValue){
        highestValue = wordValue;
        resultWord = word;
      }
    }
    return resultWord;
  }


  public static void main(String[] args) {
    System.out.println(high("man i need a taxi up to ubud"));
    System.out.println(high("what time are we climbing up to the volcano"));
    System.out.println(high("take me to semynak"));
  }
}
