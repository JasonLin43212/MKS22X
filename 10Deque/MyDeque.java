import java.util.*;

public class MyDeque<E>{

  public static void main(String[] args) {
    MyDeque<String> a = new MyDeque<>(), a1 = new MyDeque<>();
    ArrayList<String> b = new ArrayList<>();

    int size = Integer.parseInt(args[0]);
    for(int i = 0; i < size; i++){
      int temp = (int)(Math.random() * 1000);
      if(temp % 2 == 0){
        a.addFirst("" + temp);
        a1.addFirst("" + temp);
        b.add(0, "" + temp);
      }
      else{
        a.addLast("" + temp);
        a1.addLast("" + temp);
        b.add("" + temp);
      }
    }

    int index = 0;
    boolean hasError = false;
    String errorEvaluation = "Errors found at these indices: ";
    for (String x : b){
      if (!(x.equals(a.getFirst()))){
        System.out.println("The getFirst() function is incorrect at index " + index);
        hasError = true;
      }
      if (!(x.equals(a.removeFirst()))){
        System.out.println("There is an error at index " + index);
        errorEvaluation += index + ", ";
        hasError = true;
      }
      index++;
    }


    if(hasError){
      errorEvaluation = errorEvaluation.substring(0, errorEvaluation.length() - 2);
      System.out.println(errorEvaluation);
      System.out.println("MyDeque: " + a1);
      System.out.println("Actual Deque: " + b);
    }
    else{
      System.out.println("Your deque is bug-free!");
    }
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
