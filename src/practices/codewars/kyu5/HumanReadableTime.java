package practices.codewars.kyu5;

public class HumanReadableTime {
  public static String makeReadable(int seconds) {
    // Do something:
    int hours = seconds/3600;
    int minutes = (seconds-hours*3600)/60;
    int secs = seconds - hours*3600 - minutes*60;

    String hoursStr = hours<10? "0"+hours : ""+hours;
    String minutesStr = minutes<10? "0"+minutes : ""+minutes;
    String secsStr = secs<10? "0"+secs : ""+secs;

    return hoursStr + ":" + minutesStr + ":" +  secsStr;
  }

  public static String makeReadable_alternatively(int seconds) {
    int h = seconds/60/60;
    int min = seconds/60%60;
    int sec = seconds%60;
    return String.format("%02d:%02d:%02d",h,min,sec);
  }
}
