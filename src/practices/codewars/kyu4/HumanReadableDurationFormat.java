package practices.codewars.kyu4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HumanReadableDurationFormat {
  public static String formatDuration(int seconds) {
    if(seconds == 0){
      return "now";
    }

    List<String> timeUnits = Arrays.asList("year", "day", "hour", "minute", "second");
    List<Integer> secondsInTimeUnit = Arrays.asList(60*60*24*365, 60*60*24, 60*60, 60, 1);
    List<String> resultList = new ArrayList<>();

    for (int index = 0; index< secondsInTimeUnit.size(); index++){
      int timeValue = seconds/secondsInTimeUnit.get(index);
      if (timeValue != 0){
        resultList.add(createStringOf(timeValue, timeUnits.get(index)));
      }
      seconds = seconds%secondsInTimeUnit.get(index);
    }
    for (int index=0; index<resultList.size()-1; index++){
      String suffix = index<resultList.size()-2? ", ": " and ";
      resultList.set(index, resultList.get(index) + suffix);
    }
    return String.join("", resultList);
  }

  private static String createStringOf(int time, String str) {
    String timeStr = time == 1? str: str + "s";
    return time + " " + timeStr;
  }
}
