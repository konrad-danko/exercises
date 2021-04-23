package practices.codewars.kyu6;

import java.nio.CharBuffer;

public class TakeATenMinuteWalk {

  //mine
  public static boolean isValid(char[] walk) {
    int sumNS = CharBuffer.wrap(walk).chars()
        .filter(x-> x=='n' || x=='s')
        .map(x -> x=='n' ? 1 : -1)
        .sum();
    int sumWE = CharBuffer.wrap(walk).chars()
        .filter(x-> x=='w' || x=='e')
        .map(x -> x=='w' ? 1 : -1)
        .sum();
    return walk.length==10 && sumNS==0 && sumWE==0;
  }

  //best practices
  public static boolean isValid_BP(char[] walk) {
    if (walk.length != 10) {
      return false;
    }
    int x = 0, y = 0;
    for (int i = 0; i < 10; i++) {
      switch (walk[i]) {
        case 'n':
          y++;
          break;
        case 'e':
          x++;
          break;
        case 's':
          y--;
          break;
        case 'w':
          x--;
          break;
      }
    }
    return x == 0 && y == 0;
  }

  //clever
  public static boolean isValid_CL(char[] walk) {
    String s = new String(walk);
    return s.chars().filter(p->p=='n').count()==s.chars().filter(p->p=='s').count()&&
        s.chars().filter(p->p=='e').count()==s.chars().filter(p->p=='w').count()&&
        s.chars().count()==10;
  }



}
