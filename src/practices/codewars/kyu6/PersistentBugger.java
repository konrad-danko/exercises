package practices.codewars.kyu6;

public class PersistentBugger {
  public static int persistence(long n) {
    // your code
    int counter=0;
    while (n>9){
      n=String.valueOf(n)
          .chars()
          .map(Character::getNumericValue)
          .reduce(1, (a,b)-> a*b);
      counter++;
    }
    return counter;
  }

  public static void main(String[] args) {
    System.out.println(persistence(39));
    System.out.println(persistence(4));
    System.out.println(persistence(25));
    System.out.println(persistence(999));
  }
}
