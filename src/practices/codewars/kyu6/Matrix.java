package practices.codewars.kyu6;

import java.util.ArrayList;
import java.util.List;

public class Matrix<E> {

  public List<List<E>> list;
  public Matrix(int rows, int cols) {
    // TODO: Write constructor
    this.list = new ArrayList<>();
    for (int row=0; row<rows; row++){
      this.list.add(row, new ArrayList<E>());
      for (int col=0; col<cols; col++){
        this.list.get(row).add(col, null);
      }
    }
  }
  // TODO: Add get, set, setRow, swap and toArray
  public E get(int row, int col) {
    return this.list.get(row-1).get(col-1);
  }
  public void set(int row, int col, E element) {
    this.list.get(row-1).set(col-1, element);
  }
  public void setRow(int row, E[] elements){
    for (int col=1; col<=elements.length; col++){
      this.list.get(row-1).set(col-1, elements[col-1]);
    }
  }
  public void swap(int row1, int col1, int row2, int col2){
    E element1 = this.list.get(row1-1).get(col1-1);
    E element2 = this.list.get(row2-1).get(col2-1);
    this.list.get(row1-1).set(col1-1, element2);
    this.list.get(row2-1).set(col2-1, element1);
  }
  public String[][] toArray(){
    String[][] resultArray = new String[this.list.size()][this.list.get(0).size()];
    for (int row=0; row<resultArray.length; row++){
      for (int col=0; col<resultArray[0].length; col++){
        resultArray[row][col] = ""+ this.list.get(row).get(col);
      }
    }
    return resultArray;
  }
}
