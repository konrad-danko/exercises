package practices.design_paterns.decorator.star_cafe;

public class BitaSmietana  extends SkladnikDekorator{
  public BitaSmietana(Napoj napoj) {
    this.napoj = napoj;
  }

  @Override
  public String getOpis() {
    return napoj.getOpis() + ", bita śmietana";
  }

  @Override
  public double koszt() {
    return napoj.koszt() + 0.69;
  }
}
