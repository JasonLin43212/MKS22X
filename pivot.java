import java.util.*;

public class pivot {

  public static void main(String[]args){
    int[] data = {17,61,57,93,20,13,49};

    System.out.println(pivot.partition(data,1,data.length-1));
  }

  public static int partition ( int[] data, int start, int end){
    int randIndex = (int) (Math.random()*data.length);
    int randElem = data[randIndex];
    swap(data,randIndex,0);
    int currentIndex = 1;
    while (start != end){
      if (data[currentIndex] <= randElem){
        swap(data,currentIndex,start);
        start++;
        currentIndex++;
      }
      else {
        swap(data,currentIndex,end);
        end--;
      }
      System.out.println(Arrays.toString(data));
      System.out.println("start: "+ start+ " end: "+ end);
    }
    swap(data,0,start);
    System.out.println(Arrays.toString(data));
    System.out.println("randomIndex: "+ randIndex);
    System.out.println("randomElem: " + randElem );
    return start;
  }

  public static void swap(int[] data, int indexA, int indexB){
    int old = data[indexA];
    data[indexA] = data[indexB];
    data[indexB] = old;
  }
}
