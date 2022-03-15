package practices.codewars;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main03Sorting {
  public static void main(String[] args) {

    int min = 1;
    int max = 100;
    int listSize = 100000000;
    long timeStart;
    long timeEnd;


    System.out.println("Start");

    timeStart = System.currentTimeMillis();
    List<Integer> listToBeSorted = getRandomIntList(min, max, listSize);
    timeEnd = System.currentTimeMillis();
    System.out.println("Creating a random list completed in " + (timeEnd-timeStart) + " ms:");

    timeStart = System.currentTimeMillis();
    Set<Integer> set = new HashSet<>(listToBeSorted);
    timeEnd = System.currentTimeMillis();
    System.out.println("Creating a set completed in " + (timeEnd-timeStart) + " ms: " + set);

    timeStart = System.currentTimeMillis();
    Map<Integer, Long> map = listToBeSorted.stream()
        .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
    timeEnd = System.currentTimeMillis();
    System.out.println("Creating a map completed in " + (timeEnd-timeStart) + " ms: " + map);

    System.out.println("Sum of values in the 'map': " + map.values().stream().mapToLong(x->x).sum());
    System.out.println("Stop");



/*    //Collections.shuffle(listToBeSorted);
    timeStart = System.currentTimeMillis();
    Collections.sort(listToBeSorted);
    System.out.println("Sorting via 'Collections.sort' completed in " +
        (System.currentTimeMillis()-timeStart) + " ms: " + isSorted(listToBeSorted));

    Collections.shuffle(listToBeSorted);
    timeStart = System.currentTimeMillis();
    sortQuick(listToBeSorted);
    System.out.println("Sorting via 'sortQuick' completed in " +
        (System.currentTimeMillis()-timeStart) + " ms: " + isSorted(listToBeSorted));*/

/*    Collections.shuffle(listToBeSorted);
    timeStart = System.currentTimeMillis();
    sortInsertion(listToBeSorted);
    System.out.println("Sorting via 'sortInsertion' completed in " +
        (System.currentTimeMillis()-timeStart) + " ms: " + isSorted(listToBeSorted));

    Collections.shuffle(listToBeSorted);
    timeStart = System.currentTimeMillis();
    sortBubble(listToBeSorted);
    System.out.println("Sorting via 'sortBubble' completed in " +
        (System.currentTimeMillis()-timeStart) + " ms: " + isSorted(listToBeSorted));*/

  }
  private static List<Integer> getRandomIntList(int min, int max, int listSize){
    Random rand = new Random();
    return IntStream.range(0, listSize)
        .mapToObj(n-> rand.nextInt(max-min+1)+min)
        .collect(Collectors.toList());
  }
  private static boolean isSorted(List<Integer> listToCheck){
    int listSize = listToCheck.size();
    for (int index = 1; index<listSize; index++) {
      if (listToCheck.get(index-1)>listToCheck.get(index)) {
        return false;
      }
    }
    return true;
  }
  private static void sortBubble(List<Integer> listToSort){
    int sortRange = listToSort.size();
    boolean isSorted = false;
    while (!isSorted) {
      isSorted = true;
      for (int index = 1; index< sortRange; index++) {
        if (listToSort.get(index-1) > listToSort.get(index)) {
          int tempValue = listToSort.get(index - 1);
          listToSort.set(index - 1, listToSort.get(index));
          listToSort.set(index, tempValue);
          isSorted = false;
        }
      }
      sortRange--;
    }
  }
  private static void sortInsertion(List<Integer> listToSort){
    int listSize = listToSort.size();
    for (int index=1; index<listSize; index++) {
      int examinedItem = listToSort.get(index);
      int newIndex = index-1;
      while (newIndex>=0 && listToSort.get(newIndex) > examinedItem) {
        listToSort.set(newIndex+1, listToSort.get(newIndex));
        newIndex--;
      }
      listToSort.set(newIndex+1, examinedItem);
    }
  }
  private static void sortQuick(List<Integer> listToSort){
    if (new HashSet<>(listToSort).size()<2) return;

    List<Integer> leftPart = new ArrayList<>();
    List<Integer> pivotPart = new ArrayList<>();
    List<Integer> rightPart = new ArrayList<>();

    int pivot = listToSort.get(listToSort.size()/2);
    listToSort.forEach(n-> {
          if (n<pivot) leftPart.add(n);
          if (n==pivot) pivotPart.add(n);
          if (n>pivot) rightPart.add(n);
        });
    sortQuick(leftPart);
    sortQuick(rightPart);

    listToSort.clear();
    listToSort.addAll(leftPart);
    listToSort.addAll(pivotPart);
    listToSort.addAll(rightPart);
  }
  private static int binarySearch (int searchedItem, List<Integer> scannedList){
    sortQuick(scannedList);
    int minIndex = 0;
    int maxIndex = scannedList.size()-1;

    while (minIndex < maxIndex) {
      int midIndex = (minIndex+maxIndex)/2;
      if (scannedList.get(midIndex) < searchedItem) {
        minIndex = midIndex+1;
      } else {
        maxIndex = midIndex;
      }
    }
    return scannedList.get(minIndex) == searchedItem? minIndex: -1;
  }
}
