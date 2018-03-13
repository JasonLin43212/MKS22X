import java.util.*;

public class Quick{

  public static void main(String[]args){
    int[] data = {2,5,19,3,20,32,1,-1};

    System.out.println(Quick.partition(data,4,9));
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
}
