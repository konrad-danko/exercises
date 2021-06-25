package practices.codewars.kyu5;

import java.util.ArrayList;
import java.util.List;

public class Matrix {

  public List<List<Double>> list;

  public Matrix(double[][] elements) {
    // TODO: Write constructor
    if(elements==null || elements.length==0){
      throw new IllegalArgumentException("Input array must not be empty");
    }
    for (int i=0 ; i<elements.length-1 ; i++){
      if(elements[i]==null || elements[i+1]==null || elements[i].length==0 || elements[i].length!=elements[i+1].length) {
        throw new IllegalArgumentException("Illegal row length");
      }
    }
    this.list = new ArrayList<>();
    for (int row=0; row<elements.length; row++){
      this.list.add(row, new ArrayList<>());
      for (int col=0; col<elements[0].length; col++){
        this.list.get(row).add(col, elements[row][col]);
      }
    }
  }
  public Matrix(int rows, int cols, double... elements) {
    // TODO: Write constructor
    if(elements==null || elements.length==0){
      throw new IllegalArgumentException("Input array must not be empty");
    }
    if (rows * cols != elements.length){
      throw new IllegalArgumentException("Illegal length of input array");
    }
    this.list = new ArrayList<>();
    for (int row=0; row<rows; row++){
      this.list.add(row, new ArrayList<>());
      for (int col=0; col<cols; col++){
        this.list.get(row).add(col, elements[row*cols + col]);
      }
    }
  }

  public double[][] toArray() {
    double[][] resultArr = new double[this.list.size()][this.list.get(0).size()];
    for (int row=0 ; row<resultArr.length ; row++){
      for (int col=0 ; col<resultArr[0].length ; col++){
        resultArr[row][col] = this.list.get(row).get(col);
      }
    }
    return resultArr;
  }

  // TODO: Add transpose, add, mutliply(double), multiply(Matrix)
  public Matrix transpose(){
    double[][] resultArr = new double[this.list.get(0).size()][this.list.size()];
    for (int row=0 ; row<resultArr.length ; row++){
      for (int col=0 ; col<resultArr[0].length ; col++){
        resultArr[row][col] = this.list.get(col).get(row);
      }
    }
    return new Matrix(resultArr);
  }
  public Matrix add(Matrix matrix){
    if(this.list.size()!=matrix.list.size() || this.list.get(0).size()!=matrix.list.get(0).size()){
      throw new IllegalArgumentException("Rows/columns size mismatch");
    }
    double[][] resultArr = new double[this.list.size()][this.list.get(0).size()];
    for (int row=0 ; row<resultArr.length ; row++){
      for (int col=0 ; col<resultArr[0].length ; col++){
        resultArr[row][col] = this.list.get(row).get(col) + matrix.list.get(row).get(col);
      }
    }
    return new Matrix(resultArr);
  }
  public Matrix multiply(double multiplier){
    double[][] resultArr = new double[this.list.size()][this.list.get(0).size()];
    for (int row=0 ; row<resultArr.length ; row++){
      for (int col=0 ; col<resultArr[0].length ; col++){
        resultArr[row][col] = this.list.get(row).get(col) * multiplier;
      }
    }
    return new Matrix(resultArr);
  }
  public Matrix multiply(Matrix matrix){
    if(this.list.get(0).size()!=matrix.list.size()){
      throw new IllegalArgumentException("Rows/columns size mismatch");
    }
    double[][] resultArr = new double[this.list.size()][matrix.list.get(0).size()];
    for (int row=0 ; row<resultArr.length ; row++){
      for (int col=0 ; col<resultArr[0].length ; col++){
        for (int i=0 ; i<this.list.get(0).size() ; i++){
          resultArr[row][col] = resultArr[row][col] +
              this.list.get(row).get(i) * matrix.list.get(i).get(col);
        }
      }
    }
    return new Matrix(resultArr);
  }
}
