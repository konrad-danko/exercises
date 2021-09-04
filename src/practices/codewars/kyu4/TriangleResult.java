package practices.codewars.kyu4;

import java.util.List;

public class TriangleResult {
  private int nGivenPoints;
  private int nGivenColours;
  private int nTriangles;
  private List<String> colours;
  private int maxFromColour;

  public TriangleResult(final int nGivenPoints, final int nGivenColours, final int nTriangles, final List<String> colours, final int maxFromColour){
    this.nGivenPoints = nGivenPoints;
    this.nGivenColours = nGivenColours;
    this.nTriangles = nTriangles;
    this.colours = colours;
    this.maxFromColour = maxFromColour;
  }

  public TriangleResult() {
  }

  @Override
  public String toString() {
    return "[" + nGivenPoints +
          ", " + nGivenColours +
          ", " + nTriangles +
          ", " + colours +
          ", " + maxFromColour + "]";
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null || getClass() != other.getClass()) return false;

    TriangleResult that = (TriangleResult) other;

    if (nGivenPoints != that.nGivenPoints) return false;
    if (nGivenColours != that.nGivenColours) return false;
    if (nTriangles != that.nTriangles) return false;
    if (maxFromColour != that.maxFromColour) return false;
    return colours != null ? colours.equals(that.colours) : that.colours == null;
  }

  @Override
  public int hashCode() {
    int result = nGivenPoints;
    result = 31 * result + nGivenColours;
    result = 31 * result + nTriangles;
    result = 31 * result + (colours != null ? colours.hashCode() : 0);
    result = 31 * result + maxFromColour;
    return result;
  }
}
