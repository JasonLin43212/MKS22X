public class RunningMedians{

  public static void main(String[]args){
    RunningMedians r = new RunningMedians();
    System.out.println(r);
    r.add(23);
    System.out.println(r);
    r.add(12);
    System.out.println(r);
    r.add(412);
    System.out.println(r);
    r.add(132);
    System.out.println(r);
    r.add(72);
    System.out.println(r);
    r.add(15);
    System.out.println(r);
    r.add(13);
    System.out.println(r);
  }

  public MyHeap<Integer> max;
  public MyHeap<Integer> min;

  public RunningMedians() {
    max = new MyHeap(true);
    min = new MyHeap(false);
  }

  public String toString() {
    return "Max Heap: " + max + "\nMin Heap: " + min + "\nMedian: " + getMedian();
  }

  public Integer getMedian() {
    if (max.size() == 0 && min.size() == 0){
      return 0;
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

  public void add(Integer value){
    if (value.compareTo(getMedian()) > 0){
      min.add(value);
       System.out.println("added " + value + " to min");
    }
    else {
      max.add(value);
      System.out.println("added " + value + " to max");
    }
    if (Math.abs(max.size()-min.size()) > 1){
      resize();
    }
  }

  private void resize(){
    if (max.size()>min.size()){
      System.out.println("removed " + max.peek() + " from max");
      min.add(max.remove());
      System.out.println("moved " + min.peek() + " to min");
    }
    else {
      System.out.println("removed " + min.peek() + " from min");
      max.add(min.remove());
      System.out.println("moved " + max.peek() + " to max");
    }
  }

}
