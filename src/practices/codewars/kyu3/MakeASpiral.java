package practices.codewars.kyu3;

import java.util.Arrays;

public class MakeASpiral {
  public static int[][] spiralize (int size){
    int[][] resultArray = new int[size][size];
    resultArray[0][0] = 1;
    int[] currentPosition = {0,0,1};
    while (true){
      if (canMoveForward(resultArray, currentPosition)){
        moveForward(resultArray, currentPosition);
      } else if (canTurnRight(resultArray, currentPosition)) {
        turnRight(currentPosition);
      } else {
        break;
      }
    }
    return resultArray;
  }

  private static boolean canTurnRight(int[][] array, int[] position){
    int[] positionWithNewDirection = Arrays.copyOf(position, position.length);
    positionWithNewDirection[2] = getIncreasedDirection(position[2]);
    boolean canMoveForward = canMoveForward(array, positionWithNewDirection);

    int[] firstStepPosition = getNewPosition(position, 1, getIncreasedDirection(position[2]));
    int[] targetPosition = getNewPosition(firstStepPosition, 1, getIncreasedDirection(firstStepPosition[2]));
    boolean zeroOnTargetPosition = array[targetPosition[0]][targetPosition[1]] == 0;

    return canMoveForward & zeroOnTargetPosition;
  }

  private static boolean canMoveForward(int[][] array, int[] position){
    int[] nextPosition = getNewPosition(position, 1, position[2]);
    int[] secondNextPosition = getNewPosition(position, 2, position[2]);
    return (isWithinArray(nextPosition, array) && !isWithinArray(secondNextPosition,array))
        || (isWithinArray(secondNextPosition,array) && array[secondNextPosition[0]][secondNextPosition[1]] == 0);
  }

  private static boolean isWithinArray(int[] position, int[][] array){
    int arraySize = array.length;
    return position[0] >= 0
        && position[0] < arraySize
        && position[1] >= 0
        && position[1] < arraySize;
  }

  private static void moveForward(int[][] array, int[] position){
    int[] newPosition = getNewPosition(position, 1, position[2]);
    position[0] = newPosition[0];
    position[1] = newPosition[1];
    array[position[0]][position[1]] = 1;
  }

  private static int[] getNewPosition(int[] currentPosition, int stepsToMove, int direction){
    int[] result = new int[3];
    int[] directions = getDirections(direction);
    result[0] = currentPosition[0] + directions[0]*stepsToMove;
    result[1] = currentPosition[1] + directions[1]*stepsToMove;
    result[2] = direction;
    return result;
  }

  private static void turnRight(int[] position){
    position[2] = getIncreasedDirection(position[2]);
  }

  private static int getIncreasedDirection (int direction){
    return (direction+1)%4;
  }

  private static int[] getDirections(int direction){
    switch (direction){
      case 0: return new int[]{-1, 0};
      case 1: return new int[]{0, 1};
      case 2: return new int[]{1, 0};
      default: return new int[]{0, -1};
    }
  }
}
