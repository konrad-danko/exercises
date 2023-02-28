package practices.codewars.kyu8;

import java.util.HashMap;

public class UnexpectedParsing {

  private final static String STATUS = "status";
  private final static String BUSY = "busy";
  private final static String AVAILABLE = "available";

  public static HashMap<String, String> getStatus(boolean isBusy) {
    HashMap<String, String> status = new HashMap<>();
    if (isBusy) {
      status.put(STATUS, BUSY);
    } else {
      status.put(STATUS, AVAILABLE);
    }
    return status;
  }
}
