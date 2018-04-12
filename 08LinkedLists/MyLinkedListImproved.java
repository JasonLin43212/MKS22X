import java.util.Iterator;

public class MyLinkedListImproved<T extends Comparable<T>> implements Iterable<T> {

  public static void main(String[]args) {
    MyLinkedListImproved<Integer> l = new MyLinkedListImproved<>();
    MyLinkedListImproved<Integer> m = new MyLinkedListImproved<>();

    System.out.println(l);
    System.out.println(m);
    m.add(Integer.valueOf(3));
    m.add(Integer.valueOf(4));
    l.add(Integer.valueOf(9));
    l.extend(m);
    System.out.println(l);
    System.out.println(m);
  }

  private Node first,last;
  private int length;
  private boolean canPrint;
  private boolean superToStringToggle;

  public MyLinkedListImproved() {
    length = 0;
    canPrint = false;
    superToStringToggle = false;
  }

  public void print(Object obj) {
    if (canPrint) {
      System.out.println(obj);
    }
  }

  public void setPrint(boolean value) {
    canPrint = value;
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
    Node current = first;
    for (int i=0; i<length; i++){
      output += current.getValue();
      if (i != length-1){
        output += ",";
      }
      current = current.getNext();
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

  public T get(int index) {
    if (index >= length || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    Node nodeAt = getNode(index);
    return nodeAt.getValue();
  }

  public T set(int index, T newValue) {
    if (index >= length || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    Node nodeAt = getNode(index);
    T oldValue = nodeAt.getValue();
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

  public void add(T value) {
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

  public void add(int index, T value) {
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

  public int indexOf(T value) {
    Node current = first;
    for (int i=0; i<size(); i++){
      if (current.getValue().equals(value)) {
        return i;
      }
      current = current.getNext();
    }
    return -1;
  }

  public T remove(int index) {
    if (index < 0 || index >= size()){
      throw new IndexOutOfBoundsException();
    }
    T oldValue = getNode(index).getValue();
    if (index == 0){
      first = first.getNext();
      if (length > 1) {
        first.setPrev(null);
      }
    }
    else if (index == size() - 1){
      last = getNode(index-1);
      last.setNext(null);
    }
    else {
      Node previousNode = getNode(index-1);
      previousNode.setNext(previousNode.getNext().getNext());
      previousNode.getNext().setPrev(previousNode);
    }
    length--;
    return oldValue;
  }

  public boolean remove(T value) {
    Node current = first;
    for (int i=0; i<size(); i++){
      if (current.getValue().equals(value)){
        remove(i);
        return true;
      }
      current = current.getNext();
    }
    return false;
  }

  public LinkedListIterator iterator() {
    return new LinkedListIterator(first);
  }

    public int max() {
	if (size() == 0){
	    return -1;
	}
	int maxIndex = 0;
	Node current = first.getNext();
	T maxValue = first.getValue();
	for (int i=1; i<length; i++){
	    if (current.getValue().compareTo(maxValue)>0) {
		maxIndex = i;
		maxValue = current.getValue();
	    }
	    current = current.getNext();
	}
        return maxIndex;
    }

    public int min() {
	if (size() == 0){
	    return -1;
	}
	int minIndex = 0;
	Node current = first.getNext();
	T minValue = first.getValue();
	for (int i=1; i<length; i++){
	    if (current.getValue().compareTo(minValue)<0) {
		minIndex = i;
		minValue = current.getValue();
	    }
	    current = current.getNext();
	}
        return minIndex;
    }

    public void extend(MyLinkedListImproved<T> o) {
	if (size()==0){
	    first = o.first;
	    last = o.last;
	}
        else if (o.size() != 0) {
	    last.setNext(o.first);
	    o.first.setPrev(last);
	    last = o.last;
	}
	 length += o.size();
	 o.clear();
    }
  /******************************
             Node Class
   ******************************/

  private class Node {

    private Node next,prev;
    private T data;

    public Node (T value) {
      data = value;
      next = null;
      prev = null;
    }

    public Node getNext() {return next;}
    public Node getPrev() {return prev;}
    public T getValue() {return data;}

    public String toString() {return data + "";}

    public void setNext(Node newNext) {next = newNext;}
    public void setPrev(Node newPrev) {prev = newPrev;}
    public void setValue(T newValue) {data = newValue;}
  }

    /******************************
             Iterator Class
   ******************************/

  private class LinkedListIterator implements Iterator<T>{

    private Node nextNode;

    public LinkedListIterator(Node first) {
      nextNode = first;
    }

    public boolean hasNext() {
      return nextNode != null;
    }

    public T next() {
      T result = nextNode.getValue();
      nextNode = nextNode.getNext();
      return result;
    }
  }
}
