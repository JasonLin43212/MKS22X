import java.util.*;

public class Quick{

  public static void main(String[]args){
    int[]ary = { 9,8,7,6,5,4,3,2,1,-100};
    Quick.quicksort(ary);
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

  public static void quicksort (int[] ary){
    quicksortHelper(ary,0,ary.length-1);
  }

  private static void quicksortHelper (int[] ary, int start, int end){
    // Not necessary but I think this makes it run faster
    if (start == end){
      return;
    }

    int divideIndex = partition(ary,start,end);
    if (start != divideIndex){
      quicksortHelper(ary,start,divideIndex-1);
    }
    if (end != divideIndex) {
      quicksortHelper(ary,divideIndex+1,end);
    }
  }

    public static int[] dutchPartition(int[] ary, int start, int end){
	int randIndex = (int) (Math.random()*(end-start+1)+start);
	int randElem = data[randIndex];
	int lt = start + 1;
	int gt = end;
	int current = start + 1;
	swap(data,randIndex,start);
	while ( current <= gt){
	    if (data[current] = randElem){
		i++;
	    }
	    else if (data[current] > randElem){
		swap(ary,i,gt);
		gt--;
	    }
	    else {
		swap(data,lt,i);
		lt++;
		i++
	    }
	    //System.out.println(Arrays.toString(data));
	    //System.out.println("small: "+ small + " large: " + large + "\n");
	}
	swap(data,start,lt-1);
	//System.out.println(Arrays.toString(data));
	return ;
	

    }
}
