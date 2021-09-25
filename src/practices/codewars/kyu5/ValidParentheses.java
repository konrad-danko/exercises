package practices.codewars.kyu5;

public class ValidParentheses {
  public static boolean validParentheses(String parens){
    //Put code below:
    int counter = 0;
    for(char c: parens.toCharArray()){
      if(c=='(') counter++;
      if(c==')') counter--;
      if(counter<0) return false;
    }
    return counter == 0;
  }
}
