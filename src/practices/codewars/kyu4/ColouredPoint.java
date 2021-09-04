package practices.codewars.kyu4;

import java.util.Arrays;

public class ColouredPoint {
  private final int[] pos;
  private final String color;

  public ColouredPoint(final int[] pos, final String color) {
    this.pos = pos;
    this.color = color;
  }

  public int[] getPosition() {
    return pos;
  }

  public String getColour() {
    return color;
  }

  @Override
  public String toString() {
    return "[" + Arrays.toString(pos) + ", " + color + "]";
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ColouredPoint that = (ColouredPoint) o;

    if (!Arrays.equals(pos, that.pos)) return false;
    return color != null ? color.equals(that.color) : that.color == null;
  }

  @Override
  public int hashCode() {
    int result = Arrays.hashCode(pos);
    result = 31 * result + (color != null ? color.hashCode() : 0);
    return result;
  }
}