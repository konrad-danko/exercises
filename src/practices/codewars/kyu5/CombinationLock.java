package practices.codewars.kyu5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationLock {

  public static List<int[][]> combinationLock (int[][] dial, final List<Integer> combinations) {
    List<int[][]> resultList = new ArrayList<>();
    for (Integer combination : combinations){
      int[][] arrayRotated = dial;
      int rotations = combination/45;
      for (int i=1 ; i<=rotations ; i++){
        arrayRotated = rotateArray(arrayRotated);
      }
      resultList.add(arrayRotated);
    }
    return resultList;
  }
  private static int[][] rotateArray(int[][] sourceArr){
    if(!isSquare(sourceArr) && !isDiamond(sourceArr)){
      throw new IllegalArgumentException("The array is neither square nor diamond");
    }
    if(isSquare(sourceArr)){
      int[][] resultArr = new int[sourceArr.length*2-1][];
      int midRowIndex = resultArr.length/2;
      for (int resRowInd=0 ; resRowInd<resultArr.length ; resRowInd++) {
        int rowLength = resRowInd<=midRowIndex ? resRowInd+1 : resultArr.length-resRowInd;
        int srcRowIndex = resRowInd<=midRowIndex ? resRowInd : resultArr.length/2;
        resultArr[resRowInd] = new int[rowLength];
        for (int resColInd=0; resColInd<rowLength ; resColInd++){
          resultArr[resRowInd][resColInd] = sourceArr[srcRowIndex][resRowInd-srcRowIndex];
          srcRowIndex--;
        }
      }
      return resultArr;
    }
    if(isDiamond(sourceArr)){
      int resArrLength = 1+sourceArr.length/2;
      int[][] resultArr = new int[resArrLength][];
      for (int resRowInd=0 ; resRowInd<resArrLength ; resRowInd++){
        resultArr[resRowInd] = new int[resArrLength];
        int srcRowIndex = sourceArr.length/2 + resRowInd;
        for (int resColInd=0; resColInd<resArrLength ; resColInd++){
          int srcColInd = Math.min(resColInd, resRowInd);
          resultArr[resRowInd][resColInd] = sourceArr[srcRowIndex][srcColInd];
          srcRowIndex--;
        }
      }
      return resultArr;
    }
    return null;
  }
  private static boolean isSquare(int[][] array){
    for (int[] row : array){
      if (row.length != array.length) return false;
    }
    return true;
  }
  private static boolean isDiamond(int[][] array){
    if(array[0].length != 1) return false;
    if(array.length%2 == 0) return false;
    for(int row=0 ; row<array.length-1 ; row++){
      int delta = row<array.length/2 ? 1 : -1;
      if (array[row+1].length - array[row].length != delta) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    int[][] qqqq = new int[][] { new int[] {1},     new int[] {3, 2}, new int[] {4}    };
    int[][] arrDi = {{ 9}, {6,8}, {12}, {13}, {19}};
    System.out.println(isDiamond(arrDi));


    int[][] arrSq1 = {{1,2,3}, {4,5,6}, {7,8,9}};
    System.out.println(Arrays.deepToString(arrSq1));
    System.out.println(Arrays.deepToString(rotateArray(arrSq1)));
    System.out.println("");
    int[][] arrSq2 = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
    System.out.println(Arrays.deepToString(arrSq2));
    System.out.println(Arrays.deepToString(rotateArray(arrSq2)));
    System.out.println(Arrays.deepToString(rotateArray(rotateArray(arrSq2))));

    System.out.println(isDiamond(rotateArray(arrSq2)));


  }
}
