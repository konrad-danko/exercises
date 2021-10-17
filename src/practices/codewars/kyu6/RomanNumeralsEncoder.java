package practices.codewars.kyu6;

public class RomanNumeralsEncoder {
  public static String solution(int n) {
    System.out.println(n);
    StringBuilder stringBuilder = new StringBuilder();
    String[][] romanArray = new String[][] {
        {"1","I"},
        {"4","IV"},
        {"5","V"},
        {"9","IX"},
        {"10","X"},
        {"40","XL"},
        {"50","L"},
        {"90","XC"},
        {"100","C"},
        {"400","CD"},
        {"500","D"},
        {"900","CM"},
        {"1000","M"}};
    int index = romanArray.length-1;

    while (n>0) {
      int number = Integer.parseInt(romanArray[index][0]);
      if (n/number>=1) {
        stringBuilder.append(romanArray[index][1]);
        n = n-number;
      } else index--;
    }
    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    System.out.println(solution(1666));
    System.out.println(solution(2008));
    System.out.println(solution(1990));
  }
}
