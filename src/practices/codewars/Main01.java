package practices.codewars;

public class Main01 extends Thread {
/*  public static int amount = 0;
  public static long startTime = System.currentTimeMillis();

  public static void main(String[] args) {
    Main thread = new Main();
    thread.start();

    // Wait for the thread to finish
    while(thread.isAlive()) {
      System.out.println("Waiting...");
    }
    System.out.println("milis: " + (System.currentTimeMillis() - startTime));
    // Update amount and print its value
    System.out.println("Main: " + amount);
    amount++;
    System.out.println("Main: " + amount);
  }



  public void run() {
    amount++;
    System.out.println("Hello from run "+ (System.currentTimeMillis() - startTime));
  }*/

  public static long startTime = System.currentTimeMillis();
  public static int amount = 0;

  public static void main(String[] args) throws InterruptedException {

    Main01 thread = new Main01();
    System.out.println(thread.getState());
    System.out.println("Start1: " + (System.currentTimeMillis() - startTime));
    thread.start();
    System.out.println(thread.getState());
    System.out.println("Start2: " + (System.currentTimeMillis() - startTime));

    // Wait for the thread to finish
    while(thread.isAlive()) {
      long qqq = startTime%17;
      double www = Math.sqrt(startTime);
      System.out.println(thread.getState());
      //System.out.print(qqq);
      System.out.println("main method: " + (System.currentTimeMillis() - startTime));
      System.out.println(thread.getState());
    }
    System.out.println(thread.getState());
    System.out.println("Stop: " + (System.currentTimeMillis() - startTime));


  }
  public void run() {
    for (int i=1 ; i<=3 ; i++){
      System.out.println("thread: " + (System.currentTimeMillis() - startTime));
      try {
        Thread.sleep(10);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }





}
