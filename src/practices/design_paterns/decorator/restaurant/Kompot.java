package practices.design_paterns.decorator.restaurant;

public class Kompot extends Dodatek{
  public Kompot(Danie danie){
    super(danie);
    this.koszt = 2.99;
  }
}
