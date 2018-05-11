import java.util.*;

public class Sorts{

  public static void main(String[]args){
    int[] ary = {9,4,3,1,2,5,7,4,453,432,6,3,4,35,42,-4343,-123};
    Sorts.heapsort(ary);
    System.out.println(Arrays.toString(ary));
  }

  public static void heapsort(int[] ary){
    for (int i=ary.length-1; i>=0; i--){
      pushDown(i,ary,ary.length);
    }
    for (int i=0; i<ary.length; i++){
      int maxValue = ary[0];
      int sortedIndex = ary.length-1-i;
      ary[0] = ary[sortedIndex];
      pushDown(0,ary,sortedIndex);
      ary[sortedIndex] = maxValue;
    }
  }

  public static void pushUp(int index, int[]data){
    int parentIndex = (index-1)/2;
    if (data[index] > data[parentIndex]){
      swap(index,parentIndex,data);
      pushUp(parentIndex,data);
    }
  }

  private static void pushDown(int index, int[] data, int size){
    int childL = 2*index + 1;
    int childR = 2*index + 2;
    int swapIndex = index;
    if (childL < size && data[swapIndex] < data[childL]){
      swapIndex = childL;
    }
    if (childR < size && data[swapIndex] < data[childR]){
      swapIndex = childR;
    }
    if (swapIndex == index){
      return;
    }
    swap(index,swapIndex,data);
    pushDown(swapIndex,data,size);
  }

  public static void swap(int index1, int index2, int[]data){
    int temp = data[index1];
    data[index1] = data[index2];
    data[index2] = temp;
  }
}
