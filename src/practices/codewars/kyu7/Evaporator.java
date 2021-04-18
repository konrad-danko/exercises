package practices.codewars.kyu7;

public class Evaporator {
  public static int evaporator(double content, double evap_per_day, double threshold) {
    // your code
    int counter = 0;
    double currentContentPerCent = 100;
    while (currentContentPerCent>=threshold){
      currentContentPerCent = currentContentPerCent * (1-evap_per_day/100);
      counter++;
    }
    return counter;
  }

  public static void main(String[] args) {
    System.out.println(evaporator(10,50,50));
  }
}
