import java.util.*;

public class Quick{

  public static void main(String[]args){
    int[] data = new int[1000000];
    Random r = new Random(169);
    for (int i=0; i<1000000; i++){
      data[i] = r.nextInt();
    }
    long startTime = System.currentTimeMillis();
    /*
     * Test your sort here!
     */
    Quick.quicksort(data);
    long elapsedTime = System.currentTimeMillis() - startTime;
    System.out.println(elapsedTime/1000.0+"sec");
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
    quicksortHelper2(ary,0,ary.length-1);
  }

  private static void quicksortHelper (int[] ary, int start, int end){
    // Not necessary but I think this makes it run faster
    if (start >= end){
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

  private static void quicksortHelper2(int[] ary, int start, int end){
    if (end - start <= 7){
      insertionSort(ary,start,end);
	    return;
    }
    int[] output = dutchPartition(ary,start,end);
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

   public static void insertionSort(int[] data, int lo, int hi){
    for (int i=lo+1;i<hi+1;i++){
      int currentData = data[i];
      int j = i;
      while (j>lo && currentData < data[j-1]){
        data[j] = data[j-1];
        j--;
      }
      data[j] = currentData;
    }
  }
}
