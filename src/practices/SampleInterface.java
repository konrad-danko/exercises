package practices;

public interface SampleInterface {
  int getId();
  default int getAdminId1() {
    return 1;
  }
  default int getAdminId2() {
    return 1;
  }

  static void printMsg1(String msg) {
    System.out.println(msg);
  }

  static void printMsg2(String msg) {
    System.out.println(msg);
  }

}

