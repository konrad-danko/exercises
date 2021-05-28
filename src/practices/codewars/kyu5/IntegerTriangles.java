package practices.codewars.kyu5;

public class IntegerTriangles {

  //mine submitted:
  public static int giveTriang(int per) {
    // your code
    int result = 0;
    for (int a=1 ; a<=per-2*a ; a++){
      for (int b=a ; b<=per-a-b ; b++){
        int cc = a*a + b*b +a*b;
        if((a+b+Math.sqrt(cc) <= per)  &&
            cc == Math.pow(Math.round(Math.sqrt(cc)), 2)){
          result++;
        }
      }
    }
    return result;
  }

  //mine improved:
  public static int giveTriang_impr(int per) {
    int result = 0;
    for (int a=1 ; a<=per-2*a ; a++){
      for (int b=a ; b<=per-a-b ; b++){
        double c = Math.sqrt(a*a + b*b +a*b);
        if((a+b+c <= per)  && c%1==0){
          result++;
        }
      }
    }
    return result;

  }

  public static void main(String[] args) {
    System.out.println(giveTriang(5));
    System.out.println(giveTriang(15));
    System.out.println(giveTriang(30));
    System.out.println(giveTriang(50));
    System.out.println(giveTriang_impr(190));
  }
}
