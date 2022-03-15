package practices.design_paterns.decorator.star_cafe;

public class StarCafeSpecial extends Napoj{

  public StarCafeSpecial(){
    this.opis = "Specjalność firmy - kawa Star Cafe Special";
  }

  @Override
  public double koszt() {
    return 4.99;
  }
}
