package practices.codewars.kyu6;

public class SimpleCardGame {
  public String winner(String[] deckSteve, String[] deckJosh) {
    // TODO
    String sequence = "23456789TJQKA";
    int joshScore = 0;
    int steveScore = 0;
    for (int i=0; i< deckSteve.length; i++){
      String steveCard = deckSteve[i];
      String joshCard = deckJosh[i];
      if (sequence.indexOf(steveCard) < sequence.indexOf(joshCard)) joshScore++;
      if (sequence.indexOf(steveCard) > sequence.indexOf(joshCard)) steveScore++;
    }
    if (steveScore>joshScore) return "Steve wins "+steveScore+" to "+joshScore;
    if (steveScore<joshScore) return "Josh wins "+joshScore+" to "+steveScore;
    return "Tie";
  }
}
