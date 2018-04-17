import java.util.*;

public class Eval{

    public static void main(String[]args){
	Stack<Double> s = new Stack();
	s.push(2.3);
	System.out.println(s);
    }



    public class Stack<T>{
	private LinkedList<T> l;

	public void push(T value){
	    l.add(value);
	}

	public T pop(){
	    return l.remove(l.size()-1);
	}
    }
}
