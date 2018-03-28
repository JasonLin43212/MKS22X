public class MyLinkedList {

  public static void main(String[]args) {
    MyLinkedList l = new MyLinkedList();
    l.setPrint(true);
    l.add(7);
    l.add(88);
    System.out.println(l);
    
  }

  private Node first,last;
  private int length;
    private boolean canPrint;

  public MyLinkedList() {
    length = 0;
    canPrint = false;
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
    return output + "]";
  }

  public int size() {
    return length;
  }

  public int get(int index) {
    if (index >= length || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    Node nodeAt = getNode(index);
    return nodeAt.getValue();
  }

  public void set(int index, int newValue) {
    if (index >= length || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    Node nodeAt = getNode(index);
    nodeAt.setValue(newValue);
  }


    private Node getNode(int index) {
	Node current = first;
	for (int i=0; i<index; i++){
	    current = current.getNext();
	}
	return current;
    }

    public void add(int value) {
	if (size() == 0) {
	    first = new Node(value);
	    last = first;
	    length++;
	}
	else {
	    last.setNext(new Node(value));
	    last = last.getNext();
	    length++;
	}
    }

    public void print(Object obj) {
	if (canPrint) {
	    System.out.println(obj);
	}
    }

    public void setPrint(boolean value) {
	canPrint = value;
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

    public String toString() {return data + "";}

    public void setNext(Node newNext) {next = newNext;}
    public void setPrev(Node newPrev) {prev = newPrev;}
    public void setValue(int newValue) {data = newValue;}
  }
}
