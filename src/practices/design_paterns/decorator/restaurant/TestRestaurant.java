package practices.design_paterns.decorator.restaurant;

public class TestRestaurant {
  public static void main(String[] args) {
    Danie danie = new Schabowy();
    danie = new Ziemniaki(danie);
    danie = new Surowka(danie);
    danie = new Kompot(danie);
    System.out.println(danie.getOpis());
    System.out.println(danie.getKoszt());

  }
}
