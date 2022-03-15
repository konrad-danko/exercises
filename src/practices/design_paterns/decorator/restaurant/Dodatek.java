package practices.design_paterns.decorator.restaurant;

public class Dodatek extends Danie {
  public Danie danie; //tu jest kwintesencja wzorca Dekorator
  public Dodatek(Danie danie) {
    this.danie = danie;
    this.opis = this.getClass().getSimpleName();
  }

  public String getOpis() {
    return danie.getOpis() + "\n" + this.opis;
  }
  public double getKoszt() {
    return danie.getKoszt() + this.koszt;
  }
}
