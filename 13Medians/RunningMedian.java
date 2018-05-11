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
    }
    else {
      max.add(value);
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
    }
    else if (min.size() > max.size()) {
      max.add(min.remove());
    }
  }

}
