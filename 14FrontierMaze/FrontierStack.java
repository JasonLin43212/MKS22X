import java.util.*;

public class FrontierStack implements Frontier{

  private Stack<Location> data;

  public FrontierStack(){
    data = new Stack<Location>();
  }

  public Location next(){
    return data.pop();
  }

  public void add(Location n){
    data.add(n);
  }

  public boolean hasNext(){
    return data.size() != 0;
  }
}
