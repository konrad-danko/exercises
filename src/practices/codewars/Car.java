package practices.codewars;

import java.util.Arrays;
import java.util.Comparator;

public class Car implements Comparable<Car>{
  public static Car getMax(Car[] cars) {
    if (cars.length==0) throw new IllegalStateException("Bad array size");
    return Arrays.stream(cars)
        .max(Comparator.naturalOrder())
        .get();
  }

  @Override
  public int compareTo(Car o) {
    if (this.maxSpeed<o.maxSpeed) return -1;
    if (this.maxSpeed>o.maxSpeed) return 1;
    return Integer.compare(this.acceleration, o.acceleration);
  }

  ////DO NOT MODIFY ANYTHING BELOW THIS LINE

  int maxSpeed;
  int acceleration;

  public Car(int maxSpeed, int acceleration) {
    this.maxSpeed = maxSpeed;
    this.acceleration = acceleration;
  }

  @Override
  public String toString() {
    return "Car with maxSpeed=" + maxSpeed + " and acceleration=" + acceleration;
  }


}
