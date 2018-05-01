import java.util.*;

public class Sorts{

  public static void main(String[]args){
    int[] ary = {1, 1, 2, 2, 3, 4, 7, 9, 23, 53,6};
    Sorts.heapsort(ary);
    System.out.println(Arrays.toString(ary));
  }

  public static void heapsort(int[] ary){
    for (int i=ary.length; i>=0; i--){
      if (i*2+1 < ary.length){
        pushDown(i,ary,ary.length);
      }
    }
    System.out.println(Arrays.toString(ary));

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

  public static void pushDown(int index, int[] data, int size){
    int childL = 2*index + 1;
    int childR = 2*index + 2;
    if (childL >= size || childR >= size){
      return;
    }
    if (data[index] < data[childL] && data[childL] > data[childR]){
      swap(index,childL,data);
      pushDown(childL,data,size);
    }
    else if (data[index] < data[childR] && data[childR] > data[childL]){
      swap(index,childR,data);
      pushDown(childR,data,size);
    }
  }

  public static void swap(int index1, int index2, int[]data){
    int temp = data[index1];
    data[index1] = data[index2];
    data[index2] = temp;
  }
}
