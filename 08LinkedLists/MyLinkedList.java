public class MyLinkedList {

  public static void main(String[]args) {
    MyLinkedList l = new MyLinkedList();
    l.setPrint(true);
    System.out.println(l);
    l.add(2);
    l.add(25);
    l.add(32);
    l.add(4);
    System.out.println(l);
    l.add(0,88);
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

  public Integer get(int index) {
    if (index >= length || index < 0) {
      throw new IndexOutOfBoundsException();
    }
    Node nodeAt = getNode(index);
    return nodeAt.getValue();
  }

  public void set(int index, Integer newValue) {
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

    public void add(Integer value) {
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

    public void add(int index, Integer value) {
	if (index < 0 || index > length) {
	    throw new IndexOutOfBoundsException();
	}
	if (index == length) {
	    add(value);
	}
	else if (index == 0) {
	    Node newNode = new Node (value);
	    newNode.setNext(getNode(index+1));
	    first.setNext(newNode);
	}
	else {
	    Node newNode = new Node (value);
	    newNode.setNext(getNode(index+1));
	    getNode(index-1).setNext(newNode);
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
