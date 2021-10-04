package practices.codewars.kyu5;

import java.util.stream.LongStream;

public class CountIPAddresses {
  public static long ipsBetween(String start, String end) {
    return getValueOfIPAddress(end) - getValueOfIPAddress(start);
  }
  private static long getValueOfIPAddress (String addressIP){
    String[] split = addressIP.split("\\.");
    return LongStream.range(0,4)
        .map(n-> Integer.parseInt(split[(int) n]) * (long) Math.pow(256, 3-n))
        .sum();
  }

  public static void main(String[] args) {
    System.out.println(getValueOfIPAddress("255.255.255.255"));
    System.out.println(getValueOfIPAddress("10.0.0.0"));
    System.out.println(ipsBetween("10.0.0.0", "10.0.0.50"));
    System.out.println(ipsBetween("10.0.0.0", "10.0.1.0"));
    System.out.println(ipsBetween("20.0.0.10", "20.0.1.0"));
  }
}
