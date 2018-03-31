public class MyLinkedList {

  public static void main(String[]args) {
    MyLinkedList l = new MyLinkedList();
    l.setPrint(true);
    l.toggleSuper(true);
    l.add(2);
    System.out.println(l);
    l.add(3);
    System.out.println(l);
    l.add(0,43);
    System.out.println(l);
    l.add(2,29);
    System.out.println(l);
  }

  private Node first,last;
  private int length;
  private boolean canPrint;
  private boolean superToStringToggle;

  public MyLinkedList() {
    length = 0;
    canPrint = false;
    superToStringToggle = false;
  }

  public void toggleSuper(boolean value) {
    superToStringToggle = value;
  }

  public String superToString() {
    String output = "";
    for (int i=0; i<length; i++){
      Node current = getNode(i);
      output += "[" + current.getPrev() + "," + current.getValue() + "," + current.getNext() + "]\n";
    }
    return output;
  }

  public String toString() {
    String output = "[";
    for (int i=0; i<length; i++){
      output += getNode(i).getValue();
      if (i != length-1){
        output += ",";
      }
    }
    output += "]";
    if (superToStringToggle){
      output += "\n" + superToString();
    }
    return output;
  }

  public int size() {
    return length;
  }

  public Integer get(int index) {
    if (index >= length || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    Node nodeAt = getNode(index);
    return nodeAt.getValue();
  }

  public Integer set(int index, Integer newValue) {
    if (index >= length || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    Node nodeAt = getNode(index);
    Integer oldValue = nodeAt.getValue();
    nodeAt.setValue(newValue);
    return oldValue;
  }


  private Node getNode(int index) {
    Node current = first;
    for (int i=0; i<index; i++){
      current = current.getNext();
    }
    return current;
  }

  public void add(Integer value) {
    if (size() == 0) {
      first = new Node(value);
      last = first;
    }
    else {
      last.setNext(new Node(value));
      last.getNext().setPrev(last);
      last = last.getNext();
    }
    length++;
  }

  public void add(int index, Integer value) {
    if (index < 0 || index > size()) {
      throw new IndexOutOfBoundsException();
    }
    if (index == size()) {
      add(value);
    }
    else if (index == 0) {
      Node newNode = new Node (value);
      newNode.setNext(first);
      first.setPrev(newNode);
      first = newNode;
      length++;
    }
    else {
      Node newNode = new Node (value);
      newNode.setNext(getNode(index));
      newNode.setPrev(newNode.getNext().getPrev());
      newNode.getPrev().setNext(newNode);
      newNode.getNext().setPrev(newNode);
      length++;
    }
  }

  public void clear() {
    length = 0;
    first = null;
    last = null;
  }

  public void print(Object obj) {
    if (canPrint) {
      System.out.println(obj);
    }
  }

  public void setPrint(boolean value) {
    canPrint = value;
  }

  public Integer indexOf(Integer value) {
    Node current = first;
    for (int i=0; i<size(); i++){
      if (current.getValue().equals(value)) {
        return i;
      }
      current = current.getNext();
    }
    return -1;
  }

  public boolean remove(int index) {
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException();
    }
    if (index == 0){
      first = first.getNext();
      //first.setPrev(null);
    }
    else if (index == size() -1){
      last = getNode(index-1);
      last.setNext(null);
    }
    else {
      Node previousNode = getNode(index-1);
      previousNode.setNext(previousNode.getNext().getNext());
    }
    length--;
    return true;
  }

  public boolean remove(Integer value) {
    Node current = first;
    for (int i=0; i<size(); i++){
      if (current.getValue().equals(value)){
        return remove(i);
      }
      current = current.getNext();
    }
    return false;
  }

  /******************************
             Node Class
   ******************************/

  private class Node {

    private Node next,prev;
    private Integer data;

    public Node (Integer value) {
      data = value;
      next = null;
      prev = null;
    }

    public Node getNext() {return next;}
    public Node getPrev() {return prev;}
    public Integer getValue() {return data;}

    public String toString() {return data + "";}

    public void setNext(Node newNext) {next = newNext;}
    public void setPrev(Node newPrev) {prev = newPrev;}
    public void setValue(Integer newValue) {data = newValue;}
  }
}
