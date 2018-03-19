import java.util.*;

public class Quick{

  public static void main(String[]args){
    int[]ary = {120,113,111,105,103,20,14,11,9,9,9,9,9,9,9,6,4,3,2,1};

    long startTime = System.nanoTime();
    Quick.quicksort(ary);
    //System.out.println(Quick.quickselect(ary,11));
    long endTime   = System.nanoTime();
    long totalTime = endTime - startTime;
    System.out.println(totalTime);
    System.out.println(Arrays.toString(ary));
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
    /*Using old partition
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
    */
    for (int i=0; i<ary.length; i++){
	    int[] output = dutchPartition(ary,start,end);
	    int upper = output[1];
	    int lower = output[0];
	    if (k >= lower && k <= upper){
        return ary[k];
	    }
	    else if (k > upper) {
        start = upper + 1;
	    }
	    else {
        end = lower - 1;
	    }
    }
    return 0;
  }

  public static void quicksort (int[] ary){
    quicksortHelper(ary,0,ary.length-1);
  }

  private static void quicksortHelper (int[] ary, int start, int end){
    // Not necessary but I think this makes it run faster
    if (start == end){
	    return;
    }
    /*For old partition
      int divideIndex = partition(ary,start,end);
      if (start != divideIndex){
      quicksortHelper(ary,start,divideIndex-1);
      }
      if (end != divideIndex) {
      quicksortHelper(ary,divideIndex+1,end);
      }
    */

    //For Dutch partition
    int[] output = dutchPartition(ary,start,end);
    //System.out.println("start: " + start + " "  +output[0] + " end: " + end + " " + output[1]);
    //System.out.println(Arrays.toString(ary));
    if (output[0] != start){
	    quicksortHelper(ary,start,output[0]-1);
    }
    if (output[1] != end){
	    quicksortHelper(ary,output[1]+1,end);
    }
  }

  public static int[] dutchPartition(int[] ary, int start, int end){
    int randIndex = (int) (Math.random()*(end-start+1)+start);
    int randElem = ary[randIndex];
    int lt = start;
    int gt = end;
    int current = start;
    while ( current <= gt){
	    if (ary[current] == randElem){
        current++;
	    }
	    else if (ary[current] > randElem){
        swap(ary,current,gt);
        gt--;
	    }
	    else {
        swap(ary,lt,current);
        lt++;
        current++;
	    }
	    //System.out.println(Arrays.toString(ary));
	    //System.out.println("small: "+ lt + " large: " + gt + " cuurent: " + current+ " elem: " + randElem +"\n");
    }
    int[] output = new int[2];
    output[0] = lt;
    output[1] = gt;
    return output;
  }
}
