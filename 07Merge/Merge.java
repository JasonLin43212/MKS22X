import java.util.*;

public class Merge{

  public static void main(String[]args){
    int[] ary = {2,4,6,7,9,1,3,4,6,7,8};
    int[] data = new int[ary.length];
    Merge.merge(data,ary,0,4,10);
    System.out.println(Arrays.toString(ary));
    System.out.println(Arrays.toString(data));
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
}
