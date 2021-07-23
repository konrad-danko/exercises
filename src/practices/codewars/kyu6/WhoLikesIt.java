package practices.codewars.kyu6;

public class WhoLikesIt {

  //mine submitted:
  public static String whoLikesIt(String... names) {
    //Do your magic here
    int noOfLikers = names.length;
    String part1;
    switch (noOfLikers){
      case 0: part1="no one";
        break;
      case 1: part1=names[0];
        break;
      case 2: part1=names[0] + " and " + names[1];
        break;
      case 3: part1=names[0] + ", " + names[1] + " and " + names[2];
        break;
      default: part1=names[0] + ", " + names[1] + " and " + (noOfLikers-2)+ " others";
    }
    String part2 = noOfLikers<=1 ? " likes this" : " like this";
    return part1 + part2;
  }

  //best practice + clever:
  public static String whoLikesIt_BPCL(String... names) {
    switch (names.length) {
      case 0: return "no one likes this";
      case 1: return String.format("%s likes this", names[0]);
      case 2: return String.format("%s and %s like this", names[0], names[1]);
      case 3: return String.format("%s, %s and %s like this", names[0], names[1], names[2]);
      default: return String.format("%s, %s and %d others like this", names[0], names[1], names.length - 2);
    }
  }

  public static void main(String[] args) {
    System.out.println(whoLikesIt());
    System.out.println(whoLikesIt("Peter"));
    System.out.println(whoLikesIt("Jacob", "Alex"));
    System.out.println(whoLikesIt("Max", "John", "Mark"));
    System.out.println(whoLikesIt("Alex", "Jacob", "Mark", "Max"));
  }
}
