public class RunningMedians{

  public static void main(String[]args){
    RunningMedians r = new RunningMedians();
    System.out.println(r.getMedian());
  }

  public MyHeap<Integer> max;
  public MyHeap<Integer> min;

  public RunningMedians() {
    max = new MyHeap(true);
    min = new MyHeap(false);
  }

  public int getMedian() {
    if (max.size() == 0 && min.size() == 0){
      return 0;
    }
    else if (max.size() == min.size()){
      return (max.peek()/2) + (min.peek()/2);
    }
    else if (max.size() > min.size()){
      return max.peek();
    }
    else {
      return min.peek();
    }
  }

}
