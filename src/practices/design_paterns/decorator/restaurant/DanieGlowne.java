package practices.design_paterns.decorator.restaurant;

public class DanieGlowne extends Danie{

  public DanieGlowne(){
    this.opis = this.getClass().getSimpleName();
  }


  public String getOpis() {
    return this.opis;
  }
  public double getKoszt() {
    return this.koszt;
  }
}
