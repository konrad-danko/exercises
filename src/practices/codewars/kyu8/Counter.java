package practices.codewars.kyu8;

public class Counter {
  public static int countSheeps(Boolean[] arrayOfSheeps) {
    // TODO May the force be with you
    if (arrayOfSheeps==null) {
      return 0;
    }
    int counter = 0;
    for (int i=0; i< arrayOfSheeps.length; i++){
      if (arrayOfSheeps[i]!=null && arrayOfSheeps[i]==true){
        counter++;
      }
    }
    return counter;
  }

  public static void main(String[] args) {
    Boolean[] array1 = {true,  true,  true,  false,
        true,  true,  null,  true ,
        true,  false, true,  false,
        true,  false, false, true ,
        true,  true,  true,  true ,
        false, false, true,  true };

    System.out.println(countSheeps(array1));

  }
}

