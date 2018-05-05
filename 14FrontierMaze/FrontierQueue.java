import java.util.*;

public class FrontierQueue implements Frontier{

  private LinkedList<Location> data;

  public FrontierQueue(){
    data = new LinkedList<Location>();
  }

  public void add(Location n){
    data.add(n);
  }

  public Location next(){
    return data.remove();
  }

  public boolean hasNext(){
    return data.peek() != null;
  }
}
