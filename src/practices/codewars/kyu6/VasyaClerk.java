package practices.codewars.kyu6;

public class VasyaClerk {
  public static String Tickets(int[] peopleInLine) {
    //Your code is here:
    int count25=0;
    int count50=0;
    for (int bill: peopleInLine) {
      if (bill==25) {
        count25++;
        continue;
      }
      if (bill==50) {
        if (count25>=1) {
          count25--;
          count50++;
        } else return "NO";
      }
      if (bill==100) {
        if (count50>=1 && count25>=1) {
          count50--;
          count25--;
        } else if (count25>=3) {
          count25=count25-3;
        } else return "NO";
      }
    }
    return "YES";
  }

  public static void main(String[] args) {
    System.out.println(Tickets(new int[] {25, 25, 50}));
    System.out.println(Tickets(new int []{25, 100}));
  }
}
