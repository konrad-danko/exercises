package practices.codewars.kyu6;


public class LongestPalindrome {

  //mine submitted:
  public static int longestPalindrome(final String s) {
    int result=0;
    for (int i=0; i<s.length(); i++) {
      for (int j=i ; j<s.length() ; j++){
        String text=s.substring(i, j+1);
        if (isPalindrome(text) && text.length()>result){
          result=text.length();
        }
      }
    }
    return result;
  }

  private static boolean isPalindrome(String str){
    String reversedStr = new StringBuilder(str).reverse().toString();
    return str.equals(reversedStr);
  }

  //best practices + clever:
  public static int longestPalindrome_bp_cl(final String s) {
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
      for (int j = s.length(); j > i; j--) {
        StringBuilder sb = new StringBuilder(s.subSequence(i, j));
        if (sb.length() <= result) break;
        if (sb.toString().equals(sb.reverse().toString())) {
          result = sb.length();
          break;
        }
      }
    }
    return result;

  }

  public static void main(String[] args) {
    System.out.println(longestPalindrome("taadaa"));
    System.out.println(longestPalindrome("aaddaa"));
    System.out.println(longestPalindrome("aaddqaa"));
    System.out.println(longestPalindrome("aaddqdaa"));
    System.out.println(longestPalindrome("aaddqddaa"));
  }
}
