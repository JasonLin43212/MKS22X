import java.util.*;

public class MyDeque<E>{

  public static void main(String[]args){
    MyDeque<Integer> d = new MyDeque<>();
    d.addLast(23);
    d.addLast(32);
    d.addLast(232);
    System.out.println(d);

    d.removeLast();
    System.out.println(d);
    d.removeLast();

    System.out.println(d);
    d.removeLast();
    System.out.println(d);

    d.addLast(321);
    System.out.println(d);
  }

  public E[] data;
  public int size,front,back;

  public MyDeque() {
    this(10);
  }

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity) {
    if (initialCapacity < 0){
      throw new IllegalArgumentException();
    }
    data = (E[]) new Object[initialCapacity];
    size = 0;
    front = 0;
    back = 0;
  }

  public String toString() {
    /*
    String out = "[";
    for (int i=0; i<size; i++){
      out += data[(front+i)%data.length];
      if (i!=size-1){
        out += ",";
      }
    }
    return out+"]";
    */
    return Arrays.toString(data);
  }

  public int size() {
    return size;
  }

  @SuppressWarnings("unchecked")
  public void resize() {
    E[] newArr = (E[])new Object[size*2];
    for (int i=0; i<data.length; i++){
      newArr[i] = data[(i+front)%data.length];
    }
    data = newArr;
  }

  public void addLast(E value) {
    if (size == data.length){
      resize();
    }
    if (size != 0){
      back = (back+1) % data.length;
    }
    data[back] = value;
    size++;
  }

  public E removeLast() {
    E cur = data[back];
    data[back] = null;
    if (size > 1){
      back--;
    }
    size--;
    return cur;
  }

}
