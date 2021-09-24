package practices.codewars.kyu5;

public class LargestDifferenceInIncreasingIndexes {
  public static int largestDifference(int[] data) {
    //code here:
    int result = 0;
    int dataLength = data.length;
    for(int i=0; i<dataLength; i++){
      for(int j=dataLength-1; j>=0; j--){
        if((j-i)<result) break;
        if(data[i]<=data[j]){
          result = Math.max(result, j-i);
          break;
        }
      }
    }
    return result;
  }
}
