import java.util.*;

public class MyHeap<T extends Comparable<T>>{

  public static void main(String[]args){
    MyHeap<Integer> h = new MyHeap<Integer>(false);
    //[44,44,44,46,44,46,44,46,46,46,46]
    h.add(44);
    h.add(44);
    h.add(44);
    h.add(46);
    h.add(44);
    h.add(46);
    h.add(44);
    h.add(46);
    h.add(46);
    h.add(46);
    h.add(46);
    h.remove();
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
    if (childL >= size){return;}
    if (childR >= size){
      if (canPushDown(index,childL)){
        swap(index,childL);
        pushDown(childL);
      }
    }
    else if (canPushDown(index,childL)){
      if (hasPriorityOver(childL,childR)){
        swap(index,childL);
        pushDown(childL);
      }
      else {
       swap(index,childR);
       pushDown(childR);
      }
    }
    else if (canPushDown(index,childR)){
      swap(index,childR);
      pushDown(childR);
    }
  }

  public boolean canPushDown(int parent, int child){
    return isMax && data[parent].compareTo(data[child]) < 0 ||
      !isMax && data[parent].compareTo(data[child]) > 0;
  }

  public boolean hasPriorityOver(int child1, int child2){
    return isMax && data[child1].compareTo(data[child2]) >= 0 ||
      !isMax && data[child1].compareTo(data[child2]) <= 0;
  }

  private void swap(int index1, int index2){
    T temp = data[index1];
    data[index1] = data[index2];
    data[index2] = temp;
  }
}
