package practices.codewars.kyu7;

public class RoundToTheNextMultipleOf5 {

  public static int roundToNext5v1(int number) {
    for(int i=1; i<5; i++){
      if (number%5==0) {
        break;
      }
      number++;
    }
    return number;
  }

  public static int roundToNext5v2(int number) {
    while(number%5!=0) {
      number++;
    }
    return number;
  }


  public static int roundToNext5(int number) {
    if(number%5==0){
      return number;
    }
    return (int) (number>0 ? Math.floor(number/5)*5+5 : Math.ceil(number/5)*5);
  }

  public static void main(String[] args) {
    System.out.println("22: " + roundToNext5(22));
    System.out.println("21: " + roundToNext5(21));
    System.out.println("20: " + roundToNext5(20));
    System.out.println("19: " + roundToNext5(19));
    System.out.println("3: " + roundToNext5(3));
    System.out.println("1: " + roundToNext5(1));
    System.out.println("0: " + roundToNext5(0));
    System.out.println("-1: " + roundToNext5(-1));
    System.out.println("-4: " + roundToNext5(-4));
    System.out.println("-5: " + roundToNext5(-5));
    System.out.println("-7: " + roundToNext5(-7));
  }
}
