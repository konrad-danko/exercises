package practices.codewars.kyu4;

import java.util.*;
import java.util.stream.Collectors;

public class ColouredLatticePointsFormingColouredTriangles {

  public static TriangleResult countColouredTriangles(final List<ColouredPoint> lstPts) {
    // Your code here...
    int nGivenPoints = lstPts.size();

    Set<String> coloursSet = new HashSet<>();
    lstPts.forEach(x-> coloursSet.add(x.getColour()));
    int nGivenColours = coloursSet.size();

    Map<String,Integer> coloursMap = new HashMap<>();
    coloursSet.forEach(x-> coloursMap.put(x, 0));

    for (String colour: coloursSet){
      List<ColouredPoint> oneColourList = lstPts.stream()
          .filter(x-> x.getColour().equals(colour))
          .collect(Collectors.toList());
      int listSize = oneColourList.size();
      if (listSize<3) continue;
      for (int indexP1 = 0; indexP1 <listSize; indexP1++){
        for (int indexP2 = 0; indexP2 <listSize; indexP2++){
          if (indexP2 == indexP1) continue;
          for (int indexP3 = 0; indexP3 <listSize; indexP3++){
            if (indexP3 == indexP2 || indexP3 == indexP1) continue;
            if (isValidTriangle(oneColourList.get(indexP1), oneColourList.get(indexP2), oneColourList.get(indexP3))){
              int counter = coloursMap.get(colour) + 1;
              coloursMap.put(colour, counter);
            }
          }
        }
      }
    }

    int nTriangles = coloursMap.values().stream()
        .mapToInt(x->x)
        .sum()/6;
    int maxFromColour = coloursMap.values().stream()
        .max(Integer::compareTo)
        .get()/6;

    List<String> coloursOfMax = coloursSet.stream()
        .filter(x-> coloursMap.get(x)==maxFromColour*6)
        .filter(x-> coloursMap.get(x)!=0)
        .sorted()
        .collect(Collectors.toList());

    return new TriangleResult(nGivenPoints, nGivenColours, nTriangles, coloursOfMax, maxFromColour);
  }
  private static boolean isValidTriangle (ColouredPoint pointA, ColouredPoint pointB, ColouredPoint pointC){
    int determinant =
        pointA.getPosition()[0]*pointB.getPosition()[1] +
        pointB.getPosition()[0]*pointC.getPosition()[1] +
        pointC.getPosition()[0]*pointA.getPosition()[1] -
        pointB.getPosition()[0]*pointA.getPosition()[1] -
        pointA.getPosition()[0]*pointC.getPosition()[1] -
        pointC.getPosition()[0]*pointB.getPosition()[1];
    return determinant != 0;
  }


  public static void main(String[] args) {

    List<ColouredPoint> ts1 = Arrays.asList(
        new ColouredPoint(new int[]{3, -4}, "blue"),
        new ColouredPoint(new int[]{-7, -1}, "red"),
        new ColouredPoint(new int[]{7, -6}, "yellow"),
        new ColouredPoint(new int[]{2, 5}, "yellow"),
        new ColouredPoint(new int[]{1, -5}, "red"),
        new ColouredPoint(new int[]{-1, 4}, "red"),
        new ColouredPoint(new int[]{1, 7}, "red"),
        new ColouredPoint(new int[]{-3, 5}, "red"),
        new ColouredPoint(new int[]{-3, -5}, "blue"),
        new ColouredPoint(new int[]{4, 1}, "blue"));
    System.out.println(countColouredTriangles(ts1));

    List<ColouredPoint> ts2 = Arrays.asList( new ColouredPoint(new int[] {3, -4}, "blue"),  new ColouredPoint(new int[] {-7, -1}, "red"),   new ColouredPoint(new int[] {7, -6}, "yellow"),
        new ColouredPoint(new int[] {2, 5}, "yellow"), new ColouredPoint(new int[] {1, -5}, "red"),    new ColouredPoint(new int[] {1, 1}, "red"),
        new ColouredPoint(new int[] {1, 7}, "red"),    new ColouredPoint(new int[] {1, 4}, "red"),     new ColouredPoint(new int[] {-3, -5}, "blue"),
        new ColouredPoint(new int[] {4, 1}, "blue"));
    System.out.println(countColouredTriangles(ts2));

    List<ColouredPoint> ts3 = Arrays.asList( new ColouredPoint(new int[] {1, -2}, "red"),   new ColouredPoint(new int[] {7, -6}, "yellow"), new ColouredPoint(new int[] {2, 5}, "yellow"),
        new ColouredPoint(new int[] {1, -5}, "red"),   new ColouredPoint(new int[] {1, 1}, "red"),     new ColouredPoint(new int[] {1, 7}, "red"),
        new ColouredPoint(new int[] {1, 4}, "red"),    new ColouredPoint(new int[] {-3, -5}, "blue"),  new ColouredPoint(new int[] {4, 1}, "blue"));
    System.out.println(countColouredTriangles(ts3));

  }
}
