public class MyDeque<E>{

  public static void main(String[]args){
    MyDeque d = new MyDeque();
    System.out.println(d.size());
  }


  public E[] data;
  public int size;

  @SuppressWarnings("unchecked")
  public MyDeque() {
    data = (E[]) new Object[10];
    size = 0;
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity) {
    if (initialCapacity < 0){
      throw new IllegalArgumentException();
    }
    data = (E[]) new Object[initialCapacity];
    size = 0;
  }

  public int size() {
    return size;
  }

}
