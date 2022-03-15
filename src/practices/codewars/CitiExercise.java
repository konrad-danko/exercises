package practices.codewars;

import java.util.*;
import java.util.stream.Collectors;

public class CitiExercise {

  public static void main(String args[]) {
    List<String> list = new ArrayList<>();
    list.add("Java");
    list.add("Jakson");
    list.add("John");
    list.add("Rob");
    list.add("Robert");
    list.add("Adam");
    list.add("Jenkins");
    list.add("");
    list.add(null);

    System.out.println("list is " + list);
    System.out.println(getMapOfStrings(list));
    System.out.println(getMapOfStringsViaStream(list));
  }

  private static Map<String, List<String>> getMapOfStrings(List<String> list){
    Map<String, List<String>> result = new HashMap<>();
    Set<String> keySet = new HashSet<>();
    for (String word: list){
      keySet.add(getKey(word));
    }
    for(String key: keySet){
      List<String> subList = new ArrayList<>();
      for (String word: list){
        if(key.equals(getKey(word))){
          subList.add(word);
        }
      }
      result.put(key, subList);
    }
    return result;
  }

  private static Map<String, List<String>> getMapOfStringsViaStream(List<String> list){
    return list.stream()
        .filter(s-> s!=null && s.length()>0)
        .collect(Collectors.groupingBy(CitiExercise::getKey));
  }

  private static String getKey(String word){
    return word==null || word.length()==0 ? "": word.substring(0,1);
  }

}
