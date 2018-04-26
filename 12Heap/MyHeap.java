import java.util.*;

public class MyHeap{

  public static void main(String[]args){
    MyHeap h = new MyHeap(true);
    h.add("hello");
    h.add("hi");
    h.add("ha");
    h.add("boi");
    h.add("zej");
    h.add("leo");
    h.add("blue");
    h.add("pops");
    h.add("lpae");
    h.add("hd");
    h.add("kkcs");
    System.out.println(h);
  }

  private String[] data;
  private int size;
  private boolean isMax;

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

  private void resize() {
    String[] newData = new String[size*2];
    for (int i=0; i<data.length; i++){
      newData[i] = data[i];
    }
    data = newData;
  }

  public String peek(){
    if (size == 0){
      return "";
    }
    else {
      return data[0];
    }
  }

  public void add(String s) {
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

  private void pushUp(int index){
    int parentIndex = (index-1)/2;
    if (isMax && data[index].compareTo(data[parentIndex]) > 0 ||
        !isMax && data[index].compareTo(data[parentIndex]) < 0){
      swap(index,parentIndex);
      pushUp(parentIndex);
    }
  }

  private void swap(int index1, int index2){
    String temp = data[index1];
    data[index1] = data[index2];
    data[index2] = temp;
  }
}
