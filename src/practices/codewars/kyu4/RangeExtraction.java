package practices.codewars.kyu4;

public class RangeExtraction {
  public static String rangeExtraction(int[] arr) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int index=0; index<arr.length; index++) {
      stringBuilder.append(convertToStr(index, arr));
    }
    String result = stringBuilder.toString();
    return result.substring(0, result.length()-1);
  }

  private static String convertToStr(int index, int[] array){
    if (isStartOfRange(index, array)){
      return array[index] + "-";
    }
    if (isMidOfRange(index, array)){
      return "";
    }
    return array[index] + ",";
  }

  private static boolean isStartOfRange(int index, int[] array){
    return isValidIndex(index+1, array)
        && isValidIndex(index+2, array)
        && array[index+2] - array[index+1] == 1
        && array[index+1] - array[index] == 1
        && (index == 0
        || (isValidIndex(index-1, array) && array[index] - array[index-1] > 1));
  }

  private static boolean isMidOfRange(int index, int[] array){
    return isValidIndex(index-1, array)
        && isValidIndex(index+1, array)
        && array[index] - array[index-1] == 1
        && array[index+1] - array[index] == 1;
  }

  private static boolean isValidIndex(int index, int[] array){
    return index >= 0 && index < array.length;
  }
}
