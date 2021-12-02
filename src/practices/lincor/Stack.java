/*Zaprojektuj strukturę stosu, który oprócz standardowych metod Push oraz Pop
zawiera metodę PeekMin, która zwraca najmniejszą wartość aktualnie znajdującą się na stosie.
Metoda PeekMin ani żadna inna metoda w stosie nie może iterować po żadnej kolekcji.
Do wewnętrznej implementacji możesz użyć klasy  będącej częścią frameworka JAVA.*/

package practices.lincor;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Stack {

  //parametr klasy
  private final List<Integer> list;

  //konstruktor klasy
  public Stack() {
    this.list = new ArrayList<>();
  }

  //metoda dodająca element do stosu
  public void push(Integer element){
    this.list.add(element);
  }

  //metoda zdejmująca element ze stosu
  public Integer pop() throws IndexOutOfBoundsException {
    int listSize = this.list.size();
    if (listSize==0){
      throw new IndexOutOfBoundsException("Stack is empty, operation failed");
    }
    return this.list.remove(listSize-1);
  }

  //metoda zwracająca najmniejszą wartość aktualnie znajdującą się na stosie
  public Integer peekMin(){
    if (this.list.isEmpty()){
      throw new IndexOutOfBoundsException("Stack is empty, operation failed");
    }
    return new TreeSet<>(this.list).first();
  }

  public static void main(String[] args) {

    Stack stack = new Stack();
    System.out.println(stack.list);
    stack.push(5);
    stack.push(-5);
    stack.push(9);
    stack.push(-9);
    System.out.println(stack.list);
    System.out.println(stack.peekMin());
    System.out.println(stack.pop());
    System.out.println(stack.list);
    System.out.println(stack.peekMin());
    stack.push(-20);
    System.out.println(stack.list);
    System.out.println(stack.peekMin());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    //System.out.println(stack.peekMin());
    System.out.println(stack.pop());

  }
}


