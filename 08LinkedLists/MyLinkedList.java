public class MyLinkedList {

  private Node first,last;
  private int length;

  public MyLinkedList() {
    length = 0;
  }

  public String toString() {
    String output = "[";
    Node current = first;
    for (int i=0; i<length; i++){
      output += current.getValue;
      if (i != length-1){
        output += ",";
      }
    }
    return output + "]";
  }

  public int size() {
    return length;
  }

  public int get(int index) {
    if (index >= length || index < 0) {
      throw new IndexOutOfBoundsException();
      System.exit(1);
    }
    Node current = first;
    for (int i=0; i<index; i++){
      current = current.getNext();
    }
    return current.getValue();
  }

  public void set(int index, int newValue) {
    if (index >= length || index < 0) {
      throw new IndexOutOfBoundsException();
      System.exit(1);
    }
    Node current = first;
    for (int i=0; i<index; i++){
      current = current.getNext();
    }
    current.setValue(newValue);
  }

}

private class Node {

  private Node next,prev;
  private int data;

  public Node (int value) {
    data = value;
    next = null;
    prev = null;
  }

  public Node getNext() {return next;}
  public Node getPrev() {return prev;}
  public int getValue() {return data;}

  public String toString() {return data;}

  public void setNext(Node newNext) {next = newNext;}
  public void setPrev(Node newPrev) {prev = newPrev;}
  public void setValue(int newValue) {data = newValue;}
}
