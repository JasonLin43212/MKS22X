import java.util.*;

public class MyHeap<T extends Comparable<T>>{

  public static void main(String[]args){
    MyHeap<Integer> h = new MyHeap<Integer>();
    h.add(12);
     System.out.println(h);
    h.add(23);
     System.out.println(h);
    h.add(72);
     System.out.println(h);
 h.add(15);
  System.out.println(h);
    h.remove();
 System.out.println(h);
    h.add(13);
     System.out.println(h);
  }

  private T[] data;
  private int size;
  private boolean isMax;

  public MyHeap(){
    this(true);
  }

  @SuppressWarnings("unchecked")
  public MyHeap (boolean val) {
    if (val) {
      isMax = true;
    }
    else {
      isMax = false;
    }
    data = (T[]) new Comparable[10];
    size = 0;
  }

  public String toString() {
    String output = "[";
    for (int i=0; i<size; i++){
      output += data[i];
      if (i != size-1){
        output += ",";
      }
    }
    return output + "]";
  }

  public int size() {
    return size;
  }

  @SuppressWarnings("unchecked")
  private void resize() {
    T[] newData = (T[]) new Comparable[size*2];
    for (int i=0; i<data.length; i++){
      newData[i] = data[i];
    }
    data = newData;
  }

  public T peek(){
    if (size == 0){
      return null;
    }
    else {
      return data[0];
    }
  }

  public void add(T s) {
    if (size == data.length){
      resize();
    }
    if (size == 0) {
      data[0] = s;
    }
    else {
      data[size] = s;
      pushUp(size);
    }
    size++;
  }

  public T remove() {
    if (size == 0){
      return null;
    }
    T removedElem = peek();
    data[0] = data[size-1];
    size--;
    pushDown(0);
    return removedElem;
  }

  private void pushUp(int index){
    int parentIndex = (index-1)/2;
    if (isMax && data[index].compareTo(data[parentIndex]) > 0 ||
        !isMax && data[index].compareTo(data[parentIndex]) < 0){
      swap(index,parentIndex);
      pushUp(parentIndex);
    }
  }

  private void pushDown(int index){
    int childL = 2*index + 1;
    int childR = 2*index + 2;
    if (childL >= size || childR >= size){
      return;
    }
    if (isMax && data[index].compareTo(data[childL]) < 0 && data[childL].compareTo(data[childR]) > 0 ||
        !isMax && data[index].compareTo(data[childL]) > 0 && data[childL].compareTo(data[childR]) < 0){
      swap(index,childL);
      pushDown(childL);
    }
    else if (isMax && data[index].compareTo(data[childR]) < 0 && data[childR].compareTo(data[childL]) > 0 ||
             !isMax && data[index].compareTo(data[childR]) > 0 && data[childR].compareTo(data[childL]) > 0){
      swap(index,childR);
      pushDown(childR);
    }
  }

  private void swap(int index1, int index2){
    T temp = data[index1];
    data[index1] = data[index2];
    data[index2] = temp;
  }
}
