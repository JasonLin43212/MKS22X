 public class Sorts{

  public static void main(String[]args) {
    MyLinkedListImproved<Integer> l = new MyLinkedListImproved<>();
    l.add(22);
    l.add(231);
    l.add(13);
    l.add(2);
    l.add(382);
    l.add(422);
    l.add(423);
    System.out.println(l);
    Sorts.radixsort(l);
    System.out.println(findDigit(0,3));
  }

  public static void radixsort(MyLinkedListImproved<Integer> data) {
    MyLinkedListImproved[] ary = new MyLinkedListImproved[10];
    for (int i=0; i<ary.length; i++){
      ary[i] = new MyLinkedListImproved<Integer>();
    }
    int numDigitsMax = (data.get(data.max())+"").length();
    for (int i=0; i<numDigitsMax; i++){
      for (Integer current : data){
        ary[findDigit(current,i)].add(current);
      }
    }
  }

  public static int findDigit(int num, int i){
    return (int)((num%(Math.pow(10,i+1)))/(Math.pow(10,i)));
  }
}
