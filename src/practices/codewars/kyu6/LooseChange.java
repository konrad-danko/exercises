package practices.codewars.kyu6;

import java.util.HashMap;

public class LooseChange {

  //mine submitted:
  public static HashMap<String, Integer> looseChange(int cent) {
    HashMap<String, Integer> map = new HashMap<>();
    cent = cent<0 ? 0 : cent;
    map.put("Quarters", cent/25);
    cent = cent%25;
    map.put("Dimes", cent/10);
    cent = cent%10;
    map.put("Nickels", cent/5);
    map.put("Pennies", cent%5);
    return map;
  }

  public static void main(String[] args) {
    System.out.println(looseChange(29));
    System.out.println(looseChange(0));
    System.out.println(looseChange(91));
    System.out.println(looseChange(-2));
  }
}
