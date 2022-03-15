package practices.design_paterns.decorator.star_cafe;

public class Bezkofeinowa extends Napoj{

  public Bezkofeinowa(){
    this.opis = "Kawa bezkofeinowa";
  }

  @Override
  public double koszt() {
    return 5.35;
  }
}
