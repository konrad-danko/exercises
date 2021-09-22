package practices.codewars.kyu6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle {
  public static long[] generate(int level) {
    List<Long> resultList = new ArrayList<>();
    for(List<Long> sublist :getPascalList(level)){
      resultList.addAll(sublist);
    }
    return resultList.stream().mapToLong(Long::valueOf).toArray();
  }
  private static List<List<Long>> getPascalList(int level) {
    List<List<Long>> resultlList = new ArrayList<>();
    resultlList.add(List.of(1L));
    if(level==2) resultlList.add(Arrays.asList(1L, 1L));
    if(level>2){
      resultlList.add(Arrays.asList(1L, 1L));
      for(int mainIndex=2; mainIndex<=level-1; mainIndex++){
        List<Long> subList = new ArrayList<>();
        subList.add(1L);
        for(int subIndex=1; subIndex<mainIndex ; subIndex++){
          subList.add(resultlList.get(mainIndex-1).get(subIndex-1)+
              resultlList.get(mainIndex-1).get(subIndex));
        }
        subList.add(1L);
        resultlList.add(subList);
      }
    }
    return resultlList;
  }
}