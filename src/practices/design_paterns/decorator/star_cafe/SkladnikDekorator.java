package practices.design_paterns.decorator.star_cafe;

public abstract class SkladnikDekorator extends Napoj{
  public Napoj napoj;
  public abstract String getOpis();
}
