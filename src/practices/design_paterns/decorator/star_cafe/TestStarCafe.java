package practices.design_paterns.decorator.star_cafe;

public class TestStarCafe {
  public static void main(String[] args) {
    Napoj napoj1 = new Espresso();
    System.out.println(napoj1.getOpis() + ", " + napoj1.koszt());

    Napoj napoj2 = new MocnoPalona();
    napoj2 = new Czekolada(napoj2);
    napoj2 = new Czekolada(napoj2);
    napoj2 = new BitaSmietana(napoj2);
    System.out.println(napoj2.getOpis() + ", " + napoj2.koszt());

    Napoj napoj3 = new StarCafeSpecial();
    napoj3 = new MleczkoSojowe(napoj3);
    napoj3 = new Czekolada(napoj3);
    napoj3 = new BitaSmietana(napoj3);
    System.out.println(napoj3.getOpis() + ", " + napoj3.koszt());
  }
}
