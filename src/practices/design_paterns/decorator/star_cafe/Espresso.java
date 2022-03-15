package practices.design_paterns.decorator.star_cafe;

public class Espresso extends Napoj{
  public Espresso(){
    this.opis = "Kawa Espresso";
  }
  @Override
  public double koszt() {
    return 6.49;
  }
}
