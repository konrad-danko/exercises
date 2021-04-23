package practices.codewars.kyu6;

public class PlayingWithDigits {

  //mine
  public static long digPow(int n, int p) {
    String numberStr = String.valueOf(n);
    int sum = 0;
    for (int i=0 ; i<numberStr.length() ; i++) {
      int digit = Integer.parseInt(String.valueOf(numberStr.charAt(i)));
      sum = sum + (int) Math.pow(digit, p+i);
    }
    int result = sum/n;
    return result * n == sum ? result :  -1;
  }

  //clever + best practice
  public static long digPow_CL_BP(int n, int p) {
    String intString = String.valueOf(n);
    long sum = 0;
    for (int i = 0; i < intString.length(); ++i, ++p)
      sum += Math.pow(Character.getNumericValue(intString.charAt(i)), p);
    return (sum % n == 0) ? sum / n : -1;
  }

  public static void main(String[] args) {
    System.out.println(digPow(89, 1));
    System.out.println(digPow(695, 2));
    System.out.println(digPow(46288, 3));
  }
}
