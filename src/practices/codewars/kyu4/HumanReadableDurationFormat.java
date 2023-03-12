package practices.codewars.kyu4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HumanReadableDurationFormat {

  private static final String YEAR = "year";
  private static final String DAY = "day";
  private static final String HOUR = "hour";
  private static final String MINUTE = "minute";
  private static final String SECOND = "second";
  private static final String NOW = "now";

  public static String formatDuration(int seconds) {
    if(seconds == 0){
      return NOW;
    }

    int years = seconds/(60*60*24*365);
    seconds = seconds%(60*60*24*365);
    int days = seconds/(60*60*24);
    seconds = seconds%(60*60*24);
    int hours = seconds/(60*60);
    seconds = seconds%(60*60);
    int minutes = seconds/60;
    seconds = seconds%60;

    List<String> resultList = new ArrayList<>();
    resultList.add(createString(YEAR, years));
    resultList.add(createString(DAY, days));
    resultList.add(createString(HOUR, hours));
    resultList.add(createString(MINUTE, minutes));
    resultList.add(createString(SECOND, seconds));

    resultList = resultList.stream()
        .filter(str -> !str.startsWith("0"))
        .collect(Collectors.toList());
    String result = String.join(", ", resultList);
    int lastComaIndex = result.lastIndexOf(",");

    return resultList.size()==1?
        result:
        result.substring(0, lastComaIndex) + " and" + result.substring(lastComaIndex+1);
  }

  private static String createString (String str, int time) {
    String timeStr = time == 1? str: str + "s";
    return time + " " + timeStr;
  }
/*  public static void main(String[] args) {
    System.out.println(formatDuration(1));
    System.out.println(formatDuration(62));
    System.out.println(formatDuration(120));
    System.out.println(formatDuration(3600));
    System.out.println(formatDuration(3662));
  }*/
}
