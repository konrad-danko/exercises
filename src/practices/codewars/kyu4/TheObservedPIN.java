package practices.codewars.kyu4;

import java.util.*;

public class TheObservedPIN {

  private static final Map<String, String[]> OPTIONS = new HashMap<>();
  private static void initializeOptions(){
    OPTIONS.put("1", new String[]{"1", "2", "4"});
    OPTIONS.put("2", new String[]{"1", "2", "3" ,"5"});
    OPTIONS.put("3", new String[]{"2", "3", "6"});
    OPTIONS.put("4", new String[]{"1", "4", "5", "7"});
    OPTIONS.put("5", new String[]{"2", "4", "5", "6", "8"});
    OPTIONS.put("6", new String[]{"3", "5", "6", "9"});
    OPTIONS.put("7", new String[]{"4", "7", "8"});
    OPTIONS.put("8", new String[]{"5", "7", "8", "9", "0"});
    OPTIONS.put("9", new String[]{"6", "8", "9"});
    OPTIONS.put("0", new String[]{"8", "0"});
  }

  public static List<String> getPINs(String observed) {
    initializeOptions();
    List<String> resultList = new ArrayList<>();
    runLoop("", observed, resultList);
    return resultList;
  }

  private static void runLoop(String strBuiltSoFar, String pinObserved, List<String> strList){
    int indexOfPinObserved = strBuiltSoFar.length();
    String[] strOptions = OPTIONS.get(String.valueOf(pinObserved.charAt(indexOfPinObserved)));
    for (String strOption : strOptions) {
      String newStrBuiltSoFar = strBuiltSoFar + strOption;
      if (indexOfPinObserved == pinObserved.length() - 1) {
        strList.add(newStrBuiltSoFar);
      } else {
        runLoop(newStrBuiltSoFar, pinObserved, strList);
      }
    }
  }
}
