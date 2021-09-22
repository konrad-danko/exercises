package practices.codewars.kyu6;

public class IsANumberPrime {
  public static boolean isPrime(int num) {
    if (num<2) return false;
    if (num==2) return true;
    if (num%2==0) return false;
    for(int n=3; n<=Math.sqrt(num); n++){
      if (num%n == 0) return false;
    }
    return true; //TODO
    //return num > 1 && java.math.BigInteger.valueOf(num).isProbablePrime(20);
  }
}
