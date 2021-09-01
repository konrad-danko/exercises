package practices.codewars.kyu6;

public class BuildAPileOfCubes {
  public static long findNb(long m) {
    // your code
    System.out.println(m);
    long currentVolume=0;
    long counter=0;
    while(currentVolume<m){
      counter++;
      currentVolume = currentVolume + (long) Math.pow(counter, 3);
    }
    if(currentVolume == m) return counter;
    return -1;
  }

  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    System.out.println(findNb(135440716410000L));
    System.out.println(findNb(1l*1000*1000*1000*1000*1000*1000*1000*1000));
    System.out.println("Time: " + (System.currentTimeMillis()-startTime)+"ms");
  }
}
