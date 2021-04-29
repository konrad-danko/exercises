package practices.codewars.kyu6;

public class DetectPangram {

  //mine
  public boolean check(String sentence){
    return sentence
        .toLowerCase()
        .replaceAll("[^a-z]", "")
        .chars()
        .distinct()
        .count() == 26;
  }

  //best practice
  public boolean check_bp(String sentence){
    for (char c = 'a'; c<='z'; c++)
      if (!sentence.toLowerCase().contains("" + c))
        return false;
    return true;
  }

  //clever
  public boolean check_cl(String sentence){
    return sentence
        .chars()
        .map(Character::toLowerCase)
        .filter(Character::isAlphabetic)
        .distinct()
        .count() == 26;
  }
}
