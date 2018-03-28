public class MyLinkedList {

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

}
