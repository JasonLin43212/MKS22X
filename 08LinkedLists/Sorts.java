public class Sorts{

  public static void main(String[]args) {
    MyLinkedListImproved<Integer> l = new MyLinkedListImproved<Integer>();
    l.add(22);
    l.add(231);
    l.add(13);
    l.add(2);
    l.add(382);
    l.add(422);
    l.add(423);
  }

  public static void radixsort(MyLinkedListImproved<Integer> data) {
    MyLinkedListImproved<Integer>[] ary = new MyLinkedListImproved<>();
    int numDigitsMax = (data.max() + "").length();
    System.out.println(numDigitsMax);
  }
}
