package practices.design_paterns.decorator.star_cafe;

public abstract class Napoj {
  public String opis;
  public String getOpis(){
  return this.opis;
  }
  public abstract double koszt();
}
