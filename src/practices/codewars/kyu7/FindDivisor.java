package practices.codewars.kyu7;

public class FindDivisor {

  public static long numberOfDivisors(int n) {
    int counter = 0;
    for (int i=1 ; i<=n ; i++) {
      if (n%i==0){
        counter++;
      }
    }
    return counter;
    //return IntStream.range(1, n+1).filter(num-> n%num==0).count();
  }

  public static void main(String[] args) {
    System.out.println(numberOfDivisors(4));
    System.out.println(numberOfDivisors(5));
    System.out.println(numberOfDivisors(12));
    System.out.println(numberOfDivisors(30));
  }
}

