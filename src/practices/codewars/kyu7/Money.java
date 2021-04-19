package practices.codewars.kyu7;

public class Money {
  public static int calculateYears(double principal, double interest,  double tax, double desired) {
    int years = 0;
    while (principal<desired){
      years++;
      principal = principal * (1+ interest * (1- tax));
    }
    return years;
  }

  public static void main(String[] args) {
    System.out.println(calculateYears(1000,0.05,0.18,1100));
  }
}
