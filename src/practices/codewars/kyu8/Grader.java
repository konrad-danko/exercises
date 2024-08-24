package practices.codewars.kyu8;

public class Grader{
  public static String grader(double score){

    if(score>1){
      return "F";
    }
    if(score>=0.9){
      return "A";
    }
    if(score>=0.8){
      return "B";
    }
    if(score>=0.7){
      return "C";
    }
    if(score>=0.6){
      return "D";
    }
    return "F";
  }
}
