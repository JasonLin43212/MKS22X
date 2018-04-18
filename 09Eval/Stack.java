import java.util.*;

public class Stack<T>{
  public LinkedList<T> l;

  @SuppressWarnings("unchecked")
  public Stack(){
    l = new LinkedList();
  }

  public void push(T value){
    l.add(value);
  }

  public T pop() {
    return l.remove(l.size()-1);
  }

  public String toString() {
    String output = "";
    for (T val: l){
      output += val + "\n";
    }
    return output;
  }
}
