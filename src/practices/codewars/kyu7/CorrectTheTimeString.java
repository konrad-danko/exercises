package practices.codewars.kyu7;

public class CorrectTheTimeString {
  public static String timeCorrect(String timestring) {
    // your code here
    if (timestring == null || !timestring.matches("^\\d{2}:\\d{2}:\\d{2}$")) {
      return null;
    } else if (timestring.isEmpty()) {
      return timestring;
    }

    int hours = Integer.parseInt(timestring.substring(0,2));
    int minutes = Integer.parseInt(timestring.substring(3,5));
    int seconds = Integer.parseInt(timestring.substring(6,8));

    if (seconds>59) {
      minutes = minutes + seconds/60;
      seconds = seconds%60;
    }
    if (minutes>59) {
      hours = hours + minutes/60;
      minutes = minutes%60;
    }
    hours = hours%24;

    return String.format("%02d:%02d:%02d", hours, minutes, seconds);
  }
}
