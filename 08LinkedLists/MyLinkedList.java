public class MyLinkedList {

  private class Node {

    private Node next,prev;
    private int data;

    public Node (int value) {
      data = value;
      next = null;
      prev = null;
    }

    public Node getNext() {
      return next;
    }

    public Node getPrev() {
      return prev;
    }



  }

}
