package practices.coderbyte;

public class Main05_Sollers {
  public static void main(String[] args) {

    String qqq = "qqq";
    System.out.println(issymertric(qqq));


  }
  private static boolean issymertric(String str){
    //return new StringBuilder(str).reverse().equals(str);
    return str.equals(new StringBuilder(str).reverse().toString());
  }
}
