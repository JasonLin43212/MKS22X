public class MyHeap{

  public static void main(String[]args){
    MyHeap h = new MyHeap(false);
    System.out.println(h.isMax);
  }

  private String[] data;
  private int size;
  public boolean isMax;

  public MyHeap(){
    this(true);
  }

  public MyHeap (boolean val) {
    if (val) {
      isMax = true;
    }
    else {
      isMax = false;
    }
    data = new String[10];
    size = 0;
  }
}
