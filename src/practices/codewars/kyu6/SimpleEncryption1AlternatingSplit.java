package practices.codewars.kyu6;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SimpleEncryption1AlternatingSplit {
  public static String encrypt(final String text, final int n) {
    // Your code here
    if (text==null || text.isEmpty() || n<=0){
      return text;
    }
    String result = IntStream.range(0, text.length())
        .filter(x-> x%2!=0)
        .mapToObj(x-> String.valueOf(text.charAt(x)))
        .collect(Collectors.joining()) +
        IntStream.range(0, text.length())
            .filter(x-> x%2==0)
            .mapToObj(x-> String.valueOf(text.charAt(x)))
            .collect(Collectors.joining());
    return encrypt(result, n-1);
  }

  public static String decrypt(final String encryptedText, final int n) {
    // Your code here
    if (encryptedText==null || encryptedText.isEmpty() || n<=0) {
      return encryptedText;
    }
    int length = encryptedText.length();
    String result = IntStream.range(0, length/2)
        .mapToObj(x-> encryptedText.charAt(x + length/2) + String.valueOf(encryptedText.charAt(x)))
        .collect(Collectors.joining());
    result = encryptedText.length()%2==0 ? result : result + encryptedText.charAt(length-1);
    return decrypt(result, n-1);
  }

  public static void main(String[] args) {
    System.out.println(encrypt("This is a test!", 0));
    System.out.println(encrypt("This is a test!", 1));
    System.out.println(encrypt("This is a test!", 2));
    System.out.println(encrypt("This is a test!", 3));
    System.out.println(encrypt("This is a test!", 4));
    System.out.println(encrypt("This is a test!", -1));
    System.out.println(encrypt("This kata is very interesting!", 1));
    System.out.println(encrypt("01234567", 1));
    System.out.println(encrypt("012345678", 1));
    System.out.println(encrypt("0123456789", 1));
    System.out.println("***************");
    System.out.println(decrypt("13570246", 1));
    System.out.println(decrypt("135702468", 1));
    System.out.println(decrypt("This is a test!", 0));
    System.out.println(decrypt("hsi  etTi sats!", 1 ));
    System.out.println(decrypt("s eT ashi tist!", 2 ));

  }
}
