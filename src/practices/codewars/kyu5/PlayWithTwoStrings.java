package practices.codewars.kyu5;

public class PlayWithTwoStrings {

  //mine submitted:
  public static String workOnStrings(String a, String b) {
    return convertString(b, a) + convertString(a, b);
  }
  private static String convertString (String charSource, String targetStr) {
    StringBuilder singleChars = new StringBuilder();
    for(int item: charSource.toLowerCase().chars().distinct().toArray()) {
      if (charSource.toLowerCase().chars().filter(x-> x==item).count()%2==1){
        singleChars.append((char) item);
      }
    }

    StringBuilder result = new StringBuilder();
    for (int i: targetStr.chars().toArray()){
      if (singleChars.toString().contains(String.valueOf((char)i).toLowerCase())) {
        result.append(swapCharCase((char)i));
      } else result.append((char)i);
    }
    return result.toString();
  }
  private static char swapCharCase (char c) {
    return Character.isLowerCase(c)? Character.toUpperCase(c): Character.toLowerCase(c);
  }

  //best practice + clever:
  public static String workOnStrings_bp_cl(String a, String b) {
    String new_b = toggle(a, b), new_a = toggle(new_b, a);
    return new_a + new_b;
  }

  private static String toggle(String as, String bs) {
    char[] b_arr = bs.toCharArray();
    for (char a : as.toCharArray()) {
      for (int k = 0; k < b_arr.length; k++) {
        char b = b_arr[k];
        if (Character.toUpperCase(a) == Character.toUpperCase(b)) {
          //operator 'b^32' zamienia case znaku 'b'
          b_arr[k] = (char) (b ^ 32);
        }
      }
    }
    return new String(b_arr);
  }



  public static void main(String[] args) {
    System.out.println('a'^'A');
    System.out.println('A'^'a');
    for (int i=65 ; i<127 ; i++) {
      System.out.println(i + " " + (char) i + " " + (char) (i ^ 32));
    }


  }
}
