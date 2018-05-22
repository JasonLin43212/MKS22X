import java.util.*;

public class Sorts{

  public static void main(String[]args){
    int[] ary = {1,2,3,4,5};
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
    if (childL >= size){return;}
    if (childR >= size){
      if (canPushDown(index,childL,data)){
        swap(index,childL,data);
        pushDown(childL,data,size);
      }
    }
    else if (canPushDown(index,childL,data)){
      if (hasPriorityOver(childL,childR,data)){
        swap(index,childL,data);
        pushDown(childL,data,size);
      }
      else {
        swap(index,childR,data);
        pushDown(childR,data,size);
      }
    }
    else if (canPushDown(index,childR,data)){
      swap(index,childR,data);
      pushDown(childR,data,size);
    }
  }

  public static boolean canPushDown(int parent, int child, int[] data){
    return data[parent] < data[child];
  }

  public static boolean hasPriorityOver(int child1, int child2, int[] data){
    return data[child1] >= data[child2];
  }

  public static void swap(int index1, int index2, int[]data){
    int temp = data[index1];
    data[index1] = data[index2];
    data[index2] = temp;
  }
}
