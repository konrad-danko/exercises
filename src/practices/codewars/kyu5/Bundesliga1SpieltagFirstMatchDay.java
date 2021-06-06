package practices.codewars.kyu5;

import java.util.ArrayList;
import java.util.List;

public class Bundesliga1SpieltagFirstMatchDay {

  //mine submitted:
  public static String table(String[] results) {
    List<String> listUnsorted = new ArrayList<>();
    for (String s: results){
      listUnsorted.add(decode(s)[0]);
      listUnsorted.add(decode(s)[1]);
    }

    String[] listSorted = listUnsorted.stream()
        .sorted()
        .map(s -> s.substring(36))
        .toArray(String[]::new);

    listSorted[0] = listSorted[0].replaceAll("T--S", " 1. ");
    for (int index = 1; index<listSorted.length; index++){
      String numerator = index<9 ? " " + (index+1) + ". " : "" + (index+1) + ". ";
      String replacement = listSorted[index-1].substring(34).equals(listSorted[index].substring(34)) ? listSorted[index-1].substring(0, 4) : numerator ;
      listSorted[index] = listSorted[index].replaceAll("T--S", replacement);
    }
    return String.join("\n", listSorted);
  }
  private static String[] decode(String str) {
    String[] resultArr = new String[2];
    int firstSpaceIndex = str.indexOf(" ");
    int separatorTeamIndex = str.indexOf(" - ");
    int separatorGoalsIndex = str.indexOf(":");

    String team1 = (str.substring(firstSpaceIndex+1, separatorTeamIndex) + "                              ").substring(0,30);
    String team2 = (str.substring(separatorTeamIndex +3) + "                              ").substring(0,30);
    String goals1 = str.substring(0, separatorGoalsIndex);
    String goals2 = str.substring(separatorGoalsIndex+1, firstSpaceIndex);
    String played1 = "-".equals(goals1) ? "0" : "1" ;
    String played2 = "-".equals(goals2) ? "0" : "1" ;
    int intGoals1 = goals1.equals("-") ? 0 : Integer.parseInt(goals1);
    int intGoals2 = goals2.equals("-") ? 0 : Integer.parseInt(goals2);
    String won1 = intGoals1 > intGoals2 ? "1" : "0";
    String won2 = intGoals2 > intGoals1 ? "1" : "0";
    String tie = !"-".equals(goals1) && (intGoals1 == intGoals2) ? "1" : "0";
    String diff1 = intGoals1 + ":" + intGoals2;
    String diff2 = intGoals2 + ":" + intGoals1;
    String points1 = "" + (Integer.parseInt(won1) * 3 + Integer.parseInt(tie));
    String points2 = "" + (Integer.parseInt(won2) * 3 + Integer.parseInt(tie));

    String sorter1 = "" + (50 - Integer.parseInt(points1)) + (50+intGoals2-intGoals1) + (50-intGoals1) + team1.toLowerCase();
    String sorter2 = "" + (50 - Integer.parseInt(points2)) + (50+intGoals1-intGoals2) + (50-intGoals2) + team2.toLowerCase();

    resultArr[0] = sorter1 +  "T--S" + team1 + played1 + "  " + won1 + "  " + tie + "  " + won2 + "  " + diff1 + "  " + points1;
    resultArr[1] = sorter2 +  "T--S" + team2 + played2 + "  " + won2 + "  " + tie + "  " + won1 + "  " + diff2 + "  " + points2;
    return resultArr;
  }

  public static void main(String[] args) {
    String[] results = new String[]
        {
            "6:0 FC Bayern Muenchen - Werder Bremen",
            "-:- Eintracht Frankfurt - Schalke 04",
            "-:- FC Augsburg - VfL Wolfsburg",
            "-:- Hamburger SV - FC Ingolstadt",
            "-:- 1. FC Koeln - SV Darmstadt",
            "-:- Borussia Dortmund - FSV Mainz 05",
            "-:- Borussia Moenchengladbach - Bayer Leverkusen",
            "-:- Hertha BSC Berlin - SC Freiburg",
            "-:- TSG 1899 Hoffenheim - RasenBall Leipzig"
        };
    System.out.println(table(results));

  }
}
