package practices.codewars.kyu6;

public class FindTheParityOutlier {
  static int find(int[] integers){
    int countEven = 0;
    int countOdd = 0;

    for (int index=0; index<3; index++){
      int whatever = integers[index] % 2 == 0 ? countEven++ : countOdd++;
    }
    int remainderExpected = countEven > countOdd? 1: 0;
    for (int integer : integers) {
      if (Math.abs(integer) % 2 == remainderExpected) {
        return integer;
      }
    }
    return -1;
  }
}
