import java.util.*;
public class merg{

  public static void main(String[]args){
    int[] ary = {999,999,999,3,5,7,92,1,2,6,10,999,999,99,999991313,131};
    merg.merge(ary,3,6,9);

    System.out.println(Arrays.toString(ary));
  }

  public static void merge(int[] data, int start, int mid, int end){
    int inc1 = start;
    int inc2 = mid+1;
    int[] temp = new int[end-start+1];
    int tempInc = 0;
    while (inc1 <= mid && inc2 <= end) {
      if (data[inc1] <= data[inc2]){
        temp[tempInc] = data[inc1];
        inc1++;
      }
      else {
        temp[tempInc] = data[inc2];
        inc2++;
      }
      tempInc++;
    }
    while (inc1 < mid+1){
      temp[tempInc] = data[inc1];
      tempInc++;
      inc1++;
    }
    while (inc2 < end+1){
      temp[tempInc] = data[inc2];
      tempInc++;
      inc2++;
    }
    for (int i=0; i<temp.length; i++){
      data[start+i] = temp[i];
    }
  }
}
