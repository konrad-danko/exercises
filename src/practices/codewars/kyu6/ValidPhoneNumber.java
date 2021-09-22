package practices.codewars.kyu6;

public class ValidPhoneNumber {
  public static boolean validPhoneNumber(String phoneNumber) {
    // TODO: Return whether phoneNumber is in the proper form
    return phoneNumber.matches("^\\(\\d{3}\\) \\d{3}-\\d{4}$");
  }
}
