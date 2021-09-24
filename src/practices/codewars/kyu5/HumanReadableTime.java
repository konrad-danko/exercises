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
    //public static String format(String format, Object... args)
    //format - A format string as per Class Formatter
    return String.format("%02d:%05d:%03d",h,min,sec);
  }

  public static void main(String[] args) {
    int secs = 35048;
    System.out.println(makeReadable(secs));
    System.out.println(makeReadable_alternatively(secs));


    double qqq = 25 + 2d/3;
    System.out.println(qqq);
    String qqqStr = String.format("%07.2f", qqq);
    System.out.println(qqqStr);
  }
}
