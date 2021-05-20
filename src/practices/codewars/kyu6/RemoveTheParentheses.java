package practices.codewars.kyu6;

public class RemoveTheParentheses {

  //mine submitted
  public static String removeParentheses(final String str) {
    String result = str;
    while(result.contains("(")){
      int endIndex = result.indexOf(")");
      int startIndex = result.substring(0,endIndex).lastIndexOf("(");
      String textToRemove = "\\(" + result.substring(startIndex+1,endIndex) + "\\)";
      result = result.replaceAll(textToRemove,"");
    }
    return result;
  }

  //mine improved
  public static String removeParentheses_impr(final String str) {
    String result = str;
    while (result.contains("(")) {
      result = result.replaceAll("\\([a-z|A-Z| ]*\\)", "");
    }
    return result;
  }

  //best practice + clever
  public static String removeParentheses_bp_cl(final String str) {
    String updated = str.replaceAll("\\([^()]*\\)", "");
    if (updated.contains("(")) updated = removeParentheses(updated);
    return updated;


  }

  public static void main(String[] args) {
    System.out.println(removeParentheses_impr("example(unwanted thing)example"));
  }
}
