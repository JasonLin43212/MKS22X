import java.util.*;

public class MyDeque<E>{

  public static void main(String[]args){
    MyDeque<Integer> d = new MyDeque<>(4);
    d.addFirst(12);
    System.out.println(d);
    System.out.println(d.getFirst());
    System.out.println(d.getLast());
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
    front = 0;
    back = size-1;
  }

  public void addLast(E value) {
    if (value == null){
      throw new NullPointerException();
    }
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
    if (size < 1) {
      throw new NoSuchElementException();
    }
    E cur = data[back];
    data[back] = null;
    if (size > 1){
      back = (back-1+data.length) % data.length;
    }
    size--;
    return cur;
  }

  public void addFirst(E value){
    if (value == null){
      throw new NullPointerException();
    }
    if (size == data.length){
      resize();
    }
    if (size != 0){
        front = (front-1+data.length) % data.length;
    }
    data[front] = value;
    size++;
  }

  public E removeFirst(){
    if (size < 1) {
      throw new NoSuchElementException();
    }
    E cur = data[front];
    data[front] = null;
    if (size > 1){
      front = (front+1) % data.length;
    }
    size--;
    return cur;
  }

  public E getFirst() {
    if (size < 1) {
      throw new NoSuchElementException();
    }
    return data[front];
  }

  public E getLast() {
    if (size < 1) {
      throw new NoSuchElementException();
    }
    return data[back];
  }
}
