import java.util.*;

public class Eval{

  public static void main(String[]args){
    Eval.eval("8 2 + 99 9 - * 2 + 9 -");
  }

  public static double eval(String s){
    String[] tokens = new String[s.length()/2];
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


    return 2;
  }

}
