package practices.design_paterns.decorator.star_cafe;

public class MleczkoSojowe  extends SkladnikDekorator{

  public MleczkoSojowe(Napoj napoj) {
    this.napoj = napoj;
  }

  @Override
  public String getOpis() {
    return napoj.getOpis() + ", mleczko sojowe";
  }

  @Override
  public double koszt() {
    return napoj.koszt() + 0.55;
  }
}
