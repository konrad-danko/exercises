package practices.codewars.kyu4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GettingAlongWithIntegerPartitions {

  public static String part(long n) {
    // your code
    List<Integer> prodList = getProdList(n);
    int range = prodList.get(prodList.size()-1)-1;
    String average = String.format("%.2f", getAverage(prodList)).replaceAll(",", ".");
    String median = String.format("%.2f", getMedian(prodList)).replaceAll(",", ".");
    return String.format("Range: %s Average: %s Median: %s", range, average, median);
  }

  private static void calculateProdElements(List<Integer> prodList, int index, List<int[]> listOfPrimes, long n){
    for (int i=0; i<=listOfPrimes.get(index)[1]; i++) {
      listOfPrimes.get(index)[2] = i;
      int sumOfPrimes = IntStream.rangeClosed(0, index)
          .map(x-> listOfPrimes.get(x)[0] * listOfPrimes.get(x)[2])
          .sum();
      if (sumOfPrimes>n) break;
      if(index!=listOfPrimes.size()-1){
        calculateProdElements( prodList, index+1, listOfPrimes, n);
      } else {
        int prodNumber = listOfPrimes.stream()
            .mapToInt(x-> (int) Math.pow(x[0],x[2]))
            .reduce(1, (a,b)-> a*b);
        prodList.add(prodNumber);
      }
    }
  }

  private static List<Integer> getProdList (long n){
    List<int[]> listOfPrimes = new ArrayList<>();
    for (int i=2; i<=n; i++){
      boolean isPrime = true;
      for (int j=2; j<=Math.sqrt(i); j++){
        if (i % j == 0) {
          isPrime = false;
          break;
        }
      }
      if (isPrime) listOfPrimes.add(new int[]{i, (int)n/i, 0});
    }
    List<Integer> resultList = new ArrayList<>();
    calculateProdElements(resultList, 0, listOfPrimes, n);
    return resultList.stream().distinct().sorted().collect(Collectors.toList());
  }

  private static double getAverage (List<Integer> prodList){
    long sum = prodList.stream().mapToLong(x->x).sum();
    int count = prodList.size();
    return (double) sum / count;
  }

  private static double getMedian (List<Integer> prodList){
    int midIndex = prodList.size()/2;
    if (prodList.size()%2==1) return (double) prodList.get(midIndex);
    return (prodList.get(midIndex-1) + prodList.get(midIndex))/2d;
  }



/*  private static List<Integer> getProdListOLD (long n){
    List<Integer> resultList = new ArrayList<>();
    for (int i2=0; i2<=n/2; i2++){
      for (int i3=0; i3<=n/3; i3++){
        if (i2*2+i3*3>n) break;
        for (int i5=0; i5<=n/5; i5++){
          if (i2*2+i3*3+i5*5>n) break;
          for (int i7=0; i7<=n/7; i7++){
            if (i2*2+i3*3+i5*5+i7*7>n) break;
            for (int i11=0; i11<=n/11; i11++){
              if (i2*2+i3*3+i5*5+i7*7+i11*11>n) break;
              for (int i13=0; i13<=n/13; i13++){
                if (i2*2+i3*3+i5*5+i7*7+i11*11+i13*13>n) break;
                for (int i17=0; i17<=n/17; i17++){
                  if (i2*2+i3*3+i5*5+i7*7+i11*11+i13*13+i17*17>n) break;
                  for (int i19=0; i19<=n/19; i19++){
                    if (i2*2+i3*3+i5*5+i7*7+i11*11+i13*13+i17*17+i19*19>n) break;
                    for (int i23=0; i23<=n/23; i23++){
                      if (i2*2+i3*3+i5*5+i7*7+i11*11+i13*13+i17*17+i19*19+i23*23>n) break;
                      for (int i29=0; i29<=n/29; i29++){
                        if (i2*2+i3*3+i5*5+i7*7+i11*11+i13*13+i17*17+i19*19+i23*23+i29*29>n) break;
                        for (int i31=0; i31<=n/31; i31++){
                          if (i2*2+i3*3+i5*5+i7*7+i11*11+i13*13+i17*17+i19*19+i23*23+i29*29+i31*31>n) break;
                          for (int i37=0; i37<=n/37; i37++){
                            if (i2*2+i3*3+i5*5+i7*7+i11*11+i13*13+i17*17+i19*19+i23*23+i29*29+i31*31+i37*37>n) break;
                            for (int i41=0; i41<=n/41; i41++){
                              if (i2*2+i3*3+i5*5+i7*7+i11*11+i13*13+i17*17+i19*19+i23*23+i29*29+i31*31+i37*37+i41*41>n) break;
                              for (int i43=0; i43<=n/43; i43++){
                                if (i2*2+i3*3+i5*5+i7*7+i11*11+i13*13+i17*17+i19*19+i23*23+i29*29+i31*31+i37*37+i41*41+i43*43>n) break;
                                for (int i47=0; i47<=n/47; i47++){
                                  if (i2*2+i3*3+i5*5+i7*7+i11*11+i13*13+i17*17+i19*19+i23*23+i29*29+i31*31+i37*37+i41*41+i43*43+i47*47>n) break;
                                  int prodNumber = (int) (
                                      Math.pow(2,i2)*
                                      Math.pow(3,i3)*
                                      Math.pow(5,i5)*
                                      Math.pow(7,i7)*
                                      Math.pow(11,i11)*
                                      Math.pow(13,i13)*
                                      Math.pow(17,i17)*
                                      Math.pow(19,i19)*
                                      Math.pow(23,i23)*
                                      Math.pow(29,i29)*
                                      Math.pow(31,i31)*
                                      Math.pow(37,i37)*
                                      Math.pow(41,i41)*
                                      Math.pow(43,i43)*
                                      Math.pow(47,i47));
                                  resultList.add(prodNumber);
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return resultList.stream().distinct().sorted().collect(Collectors.toList());
  }
  private static boolean isPartOfProduct (long n, long productNumber) {
    if (productNumber < 1) return false;
    if (productNumber <= n) return true;

    int sumOfPrimeFactors = 0;
    while (productNumber%2==0){
      sumOfPrimeFactors = sumOfPrimeFactors + 2;
      productNumber = productNumber/2;
    }
    for (int i=3; i<=Math.sqrt(productNumber); i=i+2) {
      while (productNumber%i==0){
        sumOfPrimeFactors = sumOfPrimeFactors + i;
        productNumber = productNumber/i;
      }
    }
    productNumber = productNumber==1 ? 0 : productNumber;
    sumOfPrimeFactors = sumOfPrimeFactors + (int) productNumber;
    if (sumOfPrimeFactors==0 || sumOfPrimeFactors>n) return false;
    return true;
  }
  private static int getMaxNumber (int n) {
    if (n<1) throw new IllegalArgumentException("Liczba musi być większa os zera");
    if (n<=4) return n;
    if (n%3==0) return (int) Math.pow(3, (n/3));
    if (n%3==2)  return (int) Math.pow(3, n/3)*2;
    return (int) Math.pow(3, (n/3)-1)*4;
  }*/
  public static void main(String[] args) {
    System.out.println(getProdList(8));
    System.out.println(part(8));
  }
}
