import java.util.*;

public class Sorts{

  public static void main(String[]args){
    MyLinkedListImproved<Integer> l = new MyLinkedListImproved<>();
    l.add(5);
    l.add(25);
    l.add(-42);
    l.add(0);
    System.out.println(l);
    Sorts.radixsortIncludingNegatives(l);
    System.out.println(l);
  }

  public static void radixsort(MyLinkedListImproved<Integer> data) {
    if (data.size() == 0){
      return;
    }
    @SuppressWarnings("unchecked")
    MyLinkedListImproved<Integer>[] aryPositive = new MyLinkedListImproved[10];
    @SuppressWarnings("unchecked")
    MyLinkedListImproved<Integer>[] aryNegative = new MyLinkedListImproved[10];
    for (int i=0; i<10; i++){
      aryPositive[i] = new MyLinkedListImproved<Integer>();
      aryNegative[i] = new MyLinkedListImproved<Integer>();
    }
    int minNum = Math.abs(data.get(data.min()));
    int maxNum = Math.abs(data.get(data.max()));
    int numDigitsMax = (Math.max(minNum,maxNum)+"").length();
    for (int i=0; i<numDigitsMax; i++){
      for (Integer current : data){
        if (current < 0){
          aryNegative[9+findDigit(current,i)].add(current);
        }
        else {
          aryPositive[findDigit(current,i)].add(current);
        }
      }
      data.clear();
      for (int k=0; k<10; k++){
        data.extend(aryNegative[k]);
      }
      for (int k=0; k<10; k++){
        data.extend(aryPositive[k]);
      }
    }
  }

  public static int findDigit(int num, int i){
    return (int)((num%(Math.pow(10,i+1)))/(Math.pow(10,i)));
  }

  public static void radixsortIncludingNegatives(MyLinkedListImproved<Integer> data){
    radixsort(data);
  }
}
