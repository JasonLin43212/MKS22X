import java.util.*;

public class RunningMedian{

  public static void main(String[]args){
    RunningMedian r = new RunningMedian();
    //System.out.println(r);
    r.add(3.0);
    System.out.println(r);
    r.add(5.0);
    System.out.println(r);
    r.add(1.0);
    System.out.println(r);
    r.add(32.0);
    System.out.println(r);
    r.add(32.0);
    System.out.println(r);
    r.add(32.0);
    System.out.println(r);
    r.add(32.0);
    System.out.println(r);
    r.add(90.0);
    System.out.println(r);
  }

  public MyHeap<Double> max;
  public MyHeap<Double> min;
  public int size;

  public RunningMedian() {
    max = new MyHeap<Double>(true);
    min = new MyHeap<Double>(false);
    size = 0;
  }

  public String toString() {
    return "Max Heap: " + max + "\nMin Heap: " + min + "\nMedian: " + getMedian();
  }

  public Double getMedian() {
    if (size() == 0){
      throw new NoSuchElementException();
    }
    else if (max.size() == min.size()){
      return (max.peek() + min.peek())/2;
    }
    else if (max.size() > min.size()){
      return max.peek();
    }
    else {
      return min.peek();
    }
  }

  public void add(Double value){
    if (size == 0 || value.compareTo(getMedian()) > 0){
      min.add(value);
      System.out.println("added " + value + " to min");
      if (size != 0){
        System.out.println(this);
      }

    }
    else {
      max.add(value);
      System.out.println("added " + value + " to max");
    }
    if (Math.abs(max.size()-min.size()) > 1){
      resize();
    }
    size++;
  }

  public int size(){
    return size;
  }

  private void resize(){
    if (max.size()>min.size()){
      min.add(max.remove());
      System.out.println("removed " + min.peek() + " from max and moved to min");
    }
    else if (min.size() > max.size()) {
      max.add(min.remove());
      System.out.println("removed " + max.peek() + " from min and moved to max");
    }
  }

}
