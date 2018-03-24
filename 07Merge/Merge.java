import java.util.*;

public class Merge{

  public static void main(String[]args){
    int[] data = new int[1000000];
    Random r = new Random(169);
    for (int i=0; i<1000000; i++){
      data[i] = r.nextInt();
    }
    //Merge.merge(data,ary,0,1,2);
    long startTime = System.currentTimeMillis();
    /*
     * Test your sort here!
     */
    Merge.mergesort(data);
    long elapsedTime = System.currentTimeMillis() - startTime;
    System.out.println(elapsedTime/1000.0+"sec");
    //System.out.println(Arrays.toString(data));
    //System.out.println(Arrays.toString(temp));
  }

  public static void merge(int[] data, int[] temp, int start, int mid, int end){
    int inc1 = start;
    int inc2 = mid + 1;
    int dataIndex = start;
    while (inc1 <= mid || inc2 <= end){
	    if (inc1 > mid) {
        data[dataIndex] = temp[inc2];
        inc2++;
	    }
	    else if (inc2 > end) {
        data[dataIndex] = temp[inc1];
        inc1++;
	    }
	    else if (temp[inc1] <= temp[inc2]){
        data[dataIndex] = temp[inc1];
        inc1++;
	    }
	    else {
        data[dataIndex] = temp[inc2];
        inc2++;
	    }
	    dataIndex++;
    }
  }

  public static void mergesort(int[] data){
    int[] temp = new int[data.length];
    msort2(data,temp,0,data.length-1);
  }

  private static void msort(int[]data, int[]temp, int lo, int hi){
    if (lo >= hi){
	    return;
    }
    for (int i=lo; i<hi+1; i++){
	    temp[i] = data[i];
    }
    int mid = (lo/2) + (hi/2);
    msort(temp,data,lo,mid);
    msort(temp,data,mid+1,hi);
    merge(data,temp,lo,mid,hi);
  }

   private static void msort2(int[]data, int[]temp, int lo, int hi){
    if (hi-lo<=7){
      insertionSort(data,lo,hi);
	    return;
    }
    for (int i=lo; i<hi+1; i++){
	    temp[i] = data[i];
    }
    int mid = (lo/2) + (hi/2);
    msort(temp,data,lo,mid);
    msort(temp,data,mid+1,hi);
    merge(data,temp,lo,mid,hi);
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
