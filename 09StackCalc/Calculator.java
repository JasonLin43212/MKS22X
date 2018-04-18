import java.util.*;

public class Calculator{

  public static void main(String[]args){
    System.out.println(Calculator.eval("10 2.0 -"));
  }

  public static double eval(String s){
    int numTokens = 1;
    for (int i=0; i<s.length(); i++){
      if (s.substring(i,i+1).equals(" ")){
        numTokens++;
      }
    }
    String[] tokens = new String[numTokens];
    int tokenIndex = 0;
    String current = "";
    for (int i=0; i<s.length(); i++){
      if (s.substring(i,i+1).equals(" ")){
        tokens[tokenIndex] = current;
        current = "";
        tokenIndex++;
      }
      else {
        current += s.substring(i,i+1);
      }
    }
    tokens[tokenIndex] = current;

    @SuppressWarnings("unchecked")
      Stack<Double> values = new Stack();
    for (int i=0; i<tokens.length; i++){
      if (tokens[i].equals("+")){
        values.push(values.pop() + values.pop());
      }
      else if (tokens[i].equals("-")){
        values.push(values.pop()*-1 + values.pop());
      }
      else if (tokens[i].equals("*")){
        values.push(values.pop() * values.pop());
      }
      else if (tokens[i].equals("/")){
        values.push(1/values.pop() * values.pop());
      }
      else if (tokens[i].equals("%")){
        double firstVal = values.pop();
        values.push(values.pop() % firstVal);
      }
      else {
        values.push(Double.parseDouble(tokens[i]));
      }
    }
    return values.pop();
  }

  public static class Stack<T>{
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


}
