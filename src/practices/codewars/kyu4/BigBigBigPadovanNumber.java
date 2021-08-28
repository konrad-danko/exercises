package practices.codewars.kyu4;

import java.math.BigInteger;

public class BigBigBigPadovanNumber {

  public static BigInteger Get(long power) {
    BigInteger zero = BigInteger.ZERO;
    BigInteger one = BigInteger.ONE;
    BigInteger[][] baseMatrice = {{zero, one, zero},
                                  {zero, zero, one},
                                  {one, one, zero}};
    return powerMatrice(baseMatrice, power+1)[2][1];
  }

  private static BigInteger[][] multiplyMatrices(BigInteger[][] matriceA, BigInteger[][] matriceB){
    if(matriceA[0].length != matriceB.length ){
      throw new IllegalArgumentException("Rows/columns size mismatch");
    }
    BigInteger[][] resultMatrice = new BigInteger[matriceA.length][matriceB[0].length];
    for (int row=0; row<resultMatrice.length ; row++){
      for (int col=0; col<resultMatrice[0].length ; col++){
        resultMatrice[row][col] = BigInteger.ZERO;
        for (int i=0 ; i<matriceA[0].length ; i++){
          resultMatrice[row][col] = resultMatrice[row][col]
              .add(matriceA[row][i].multiply(matriceB[i][col]));
        }
      }
    }
    return resultMatrice;
  }

  private static BigInteger[][] powerMatrice(BigInteger[][] matrice, long power){
    if (power<=1) return matrice;
    if (power%2==1) {
      return multiplyMatrices(matrice, powerMatrice(matrice, power-1));
    }
    BigInteger[][] tempMatrice = powerMatrice(matrice, power/2);
    return multiplyMatrices(tempMatrice, tempMatrice);
  }

  private static BigInteger getPadovan(long power) {
    if (power<=2) return BigInteger.ONE;
    BigInteger itemMinus3 = BigInteger.ONE;
    BigInteger itemMinus2 = BigInteger.ONE;
    BigInteger itemMinus1 = BigInteger.ONE;
    BigInteger itemMinus0 = BigInteger.ZERO;

    for (int counter = 3; counter <=power; counter++) {
      itemMinus0 = itemMinus3.add(itemMinus2);
      itemMinus3 = itemMinus2;
      itemMinus2 = itemMinus1;
      itemMinus1 = itemMinus0;
    }
    return itemMinus0;
  }
  public static void main(String[] args) {
    long number = 1000000;

    long startTime1 = System.currentTimeMillis();
    BigInteger oldStyle = getPadovan(number);
    //System.out.println(number + ": " + oldStyle);
    System.out.println("Time old: " + (System.currentTimeMillis()- startTime1) + " ms");

    long startTime2 = System.currentTimeMillis();
    BigInteger newStyle = Get(number);
    //System.out.println(number + ": " + newStyle);
    System.out.println("Time new: " + (System.currentTimeMillis()- startTime2) + " ms");

    System.out.println("Diff: " + oldStyle.subtract(newStyle));

    for (long power = 100000; power <=4000000; power = power +100000) {
      long startTime = System.currentTimeMillis();
      BigInteger padovan = Get(power);
      long endTime = System.currentTimeMillis();
      System.out.println(power + ": " + (endTime - startTime) + "ms\n");
    }
  }
}
