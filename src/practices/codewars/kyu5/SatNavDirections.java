package practices.codewars.kyu5;

import java.awt.*;

public class SatNavDirections {
  public static Point satNav(final String[] directions) {
    // Your code here!
    int headInt=0, x=0, y=0;
    for (int index=0 ; index<directions.length-1 ; index++){
      int[] parameters = getParameters(directions[index]);
      if (headInt==0){
        y = parameters[0]==0 ? (int) (Math.floor(y/10d)*10 + parameters[1]) : y + parameters[1];
      }
      if (headInt==1){
        x = parameters[0]==0 ? (int) (Math.floor(x/10d)*10 + parameters[1]) : x + parameters[1];
      }
      if (headInt==2){
        y = parameters[0]==0 ? (int) (Math.ceil(y/10d)*10 - parameters[1]) : y - parameters[1];
      }
      if (headInt==3){
        x = parameters[0]==0 ? (int) (Math.ceil(x/10d)*10 - parameters[1]) : x - parameters[1];
      }
      headInt = (headInt + parameters[2])%4;
    }
    return new Point(x, y);
  }

  private static int[] getParameters(String str){
    int[] result = new int[3];
    if (str.startsWith("Head")){
      switch (str.substring(5)){
        case "EAST":
          result[2] = 1;
          break;
        case "SOUTH":
          result[2] = 2;
          break;
        case "WEST":
          result[2] = 3;
          break;
      }
    }
    if (str.startsWith("Take")){
      if ("N".equals(str.substring(9, 10))) {
        result[1] = 10;
      } else {
        result[1] = Integer.parseInt(str.substring(9, 10))*10;
      }
      if (str.endsWith("LEFT")){
        result[2] = 3;
      } else {
        result[2] = 1;
      }
    }
    if (str.startsWith("Go")){
      result[0] = 1;
      int lastSpace = str.lastIndexOf(" ");
      if (str.endsWith("km")){
        result[1] = Integer.parseInt("" + str.charAt(lastSpace+1) + str.charAt(lastSpace+3));
      } else {
        result[1] = Integer.parseInt("" + str.charAt(lastSpace+1));
      }
      result[2] = 0;
    }
    if (str.startsWith("Turn")){
      result[0] = 1;
      result[1] = 0;
      result[2] = 2;
    }
    return result;
  }
}


