import java.util.*;

public class Quick{

  public static void main(String[]args){
    int[]ary = { 2,4, 10,5, 15, 23, 0,  5,4,10,-1,30};

    System.out.println(Quick.quickselect(ary,0));
    System.out.println(Quick.quickselect(ary,1));
    System.out.println(Quick.quickselect(ary,2));
    System.out.println(Quick.quickselect(ary,3));
    System.out.println(Quick.quickselect(ary,4));
    System.out.println(Quick.quickselect(ary,5));
  }

  public static int partition ( int[] data, int start, int end){
    int randIndex = (int) (Math.random()*(end-start+1)+start);
    int randElem = data[randIndex];
    int small = start + 1;
    int large = end;
    swap(data,randIndex,start);
    while (small <= large){
      if (data[small] <= randElem){
        small++;
      }
      else {
        swap(data,small,large);
        large--;
      }
      //System.out.println(Arrays.toString(data));
      //System.out.println("small: "+ small + " large: " + large + "\n");
    }
    swap(data,start,large);
    //System.out.println(Arrays.toString(data));
    return large;
  }

  public static void swap(int[] data, int indexA, int indexB){
    int old = data[indexA];
    data[indexA] = data[indexB];
    data[indexB] = old;
  }

  public static int quickselect(int[] ary, int k){
    int start = 0;
    int end = ary.length -1;
    for (int i=0; i<ary.length; i++){
      int foundIndex = partition(ary,start,end);
      if (foundIndex == k) {
        return ary[foundIndex];
      }
      else if (foundIndex < k){
        start = foundIndex + 1;
      }
      else {
        end = foundIndex - 1;
      }
    }
    return 0;
  }
}
