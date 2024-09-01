package practices.codewars.kyu4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Snail {

  private static int[] currentSourcePosition;
  private static int currentTargetIndex;
  private static List<String> usedPositions;

  public static int[] snail(int[][] array) {
    initializeStaticValues();
    int arrayLength = (int) Math.pow(array[0].length, 2);
    int[] result = new int[arrayLength];
    for (int i=0; i<arrayLength; i++){
      processSingleStep(array,result);
    }
    return result;
  }

  private static void initializeStaticValues(){
    currentSourcePosition = new int[3];
    currentSourcePosition[1] = -1;
    currentSourcePosition[2] = 1;
    currentTargetIndex = -1;
    usedPositions = new ArrayList<>();
  }

  private static void processSingleStep(int[][] array, int[] result){
    if(!canMoveForward(array)){
      turnRight();
    }
    moveForward();
    copyValueFromTo(array, result);
    markPositionAsUsed();
  }

  private static boolean canMoveForward(int[][] array){
    return isWithinArray(array) && !isUsedAlready();
  }

  private static boolean isWithinArray(int[][] array){
    int maxIndex = array[0].length-1;
    int[] newPosition = getNewPosition();
    return newPosition[0]>=0 && newPosition[1]>=0 &&
        newPosition[0]<=maxIndex && newPosition[1]<=maxIndex;
  }

  private static int[] getNewPosition(){
    int[] direction;
    switch (currentSourcePosition[2]){
      case 1:
        direction = new int[]{0, 1};
        break;
      case 2:
        direction = new int[]{1, 0};
        break;
      case 3:
        direction = new int[]{0, -1};
        break;
      default:
        direction = new int[]{-1, 0};
        break;
    }
    int[] result = new int[3];
    result[0] = currentSourcePosition[0] + direction[0];
    result[1] = currentSourcePosition[1] + direction[1];
    result[2] = currentSourcePosition[2];
    return result;
  }

  private static boolean isUsedAlready(){
    int[] newPosition = getNewPosition();
    return usedPositions.contains(newPosition[0] + "-" + newPosition[1]);
  }

  private static void turnRight(){
    currentSourcePosition[2] = (currentSourcePosition[2]+1)%4;
  }

  private static void moveForward(){
    int[] newPosition = getNewPosition();
    currentSourcePosition[0] = newPosition[0];
    currentSourcePosition[1] = newPosition[1];
    currentSourcePosition[2] = newPosition[2];
    currentTargetIndex++;
  }

  private static void copyValueFromTo(int[][] array, int[] result){
    result[currentTargetIndex] = array[currentSourcePosition[0]][currentSourcePosition[1]];
  }

  private static void markPositionAsUsed(){
    usedPositions.add(currentSourcePosition[0] + "-" + currentSourcePosition[1]);
  }

  public static void main(String[] args) {
    int[][] array1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[][] array2 = {{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};

    System.out.println(Arrays.toString(snail(array1)));
    System.out.println(Arrays.toString(snail(array2)));
  }
}
