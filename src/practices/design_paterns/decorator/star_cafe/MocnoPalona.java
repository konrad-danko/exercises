package practices.design_paterns.decorator.star_cafe;

public class MocnoPalona extends Napoj{

  public MocnoPalona(){
    this.opis = "Kawa Mocno Palona";
  }

  @Override
  public double koszt() {
    return 5.21;
  }
}
