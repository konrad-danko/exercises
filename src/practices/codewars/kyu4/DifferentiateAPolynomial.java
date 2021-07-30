package practices.codewars.kyu4;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DifferentiateAPolynomial {
  //mine submitted:
  public static BigInteger differentiate(String equation, long x) {
    // Your code here!
    return Arrays.stream(equation
        .replaceAll("-", "|-")
        .replaceAll("\\+", "|+")
        .split("\\|"))
        .filter(str -> str.contains("x"))
        .map(str-> calcDiff(str, x))
        .reduce(new BigInteger("0"), BigInteger::add);
  }
  private static BigInteger calcDiff(String str, long x){
    String strUpToX = str.substring(0, str.indexOf("x"));
    String coefficientStr = strUpToX.equals("-") || strUpToX.equals("+") || strUpToX.equals("")?
        strUpToX + "1":
        strUpToX;
    BigInteger coefficient = new BigInteger(coefficientStr);
    String powerStr = str.contains("^") ? str.substring(str.indexOf("^")+1) : "1";
    BigInteger power = new BigInteger(powerStr);
    return power.multiply(coefficient).multiply(BigInteger.valueOf(x).pow(power.intValue()-1));
  }

  //also best practice:
  private static final Pattern TERM = Pattern.compile("(.*?)x(\\^\\d+)?");
  public static BigInteger differentiate_BP(String equation, long x) {
    BigInteger xb = BigInteger.valueOf(x);
    BigInteger result = BigInteger.ZERO;
    Matcher m = TERM.matcher(equation);
    while (m.find()) {
      long k = 1;
      String ks = m.group(1);
      if (!ks.isEmpty() && !ks.equals("+"))
        k = ks.equals("-") ? -1 : Long.parseLong(ks);
      int p = 1;
      String ps = m.group(2);
      if (ps != null)
        p = Integer.parseInt(ps.substring(1));
      result = result.add(BigInteger.valueOf(k).multiply(BigInteger.valueOf(p)).multiply(xb.pow(p - 1)));
    }
    return result;
  }


  public static void main(String[] args) {
    System.out.println(differentiate_BP("12x+2", 3));
    System.out.println(differentiate_BP("x^2-x", 3));
    System.out.println(differentiate_BP("-5x^2+10x+4", 3));
    System.out.println(differentiate_BP("-21x^5+3x^3",12398));
    System.out.println(differentiate_BP("x^4",59884848483559L));
    System.out.println(differentiate_BP("-7x^5+22x^4-55x^3-94x^2+87x-56",-3));
  }
}
