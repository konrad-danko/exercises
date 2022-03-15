package practices.bicycle;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MainBicycle {
  public static void main(String[] args) {
    Bicycle bike01 = new Bicycle("Brand01", 13);
    Bicycle bike02 = new Bicycle("Brand02", 122);
    Bicycle bike03 = new Bicycle("Brand03", 11);
    List<Bicycle> bikes = Arrays.asList(bike01, bike02, bike03);

    BicycleComparator bikeFrameSizeComparator = new BicycleComparator();
    bikes.stream()
        .sorted(bikeFrameSizeComparator::compare)
        .sorted((a, b)-> b.getFrameSize().compareTo(a.getFrameSize()))
        //.sorted(bikeFrameSizeComparator.reversed())
        .forEach(System.out::println);


    List<String> bikeBrands = Arrays.asList("Giant", "Scott", "Trek", "GT");
    String[] arr = bikeBrands.toArray(String[]::new);


  }
}
