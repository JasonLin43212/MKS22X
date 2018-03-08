import java.util.*;
import java.io.*;

public class USACO {
    
  public static void main(String[]args){
    System.out.println(USACO.bronze("bronze4.dat"));
  }


  public static int bronze(String filename){
    int[][] data;
    int row,col,elevation,numInstructions;
    try {
	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    row = Integer.parseInt(in.next());
	    col = Integer.parseInt(in.next());
	    elevation = Integer.parseInt(in.next());
	    numInstructions = Integer.parseInt(in.next());
	    data = new int[row][col];
	    for (int i=0; i<row; i++){
        for (int j=0; j<col; j++){
          data[i][j] = Integer.parseInt(in.next());
        }
	    }
	    for (int i=0; i<numInstructions; i++){
        stomp(Integer.parseInt(in.next())-1,
              Integer.parseInt(in.next())-1,
              Integer.parseInt(in.next()),
              data);
	    }
      int aggDepth = 0;
      for (int i=0; i<row; i++){
        for (int j=0; j<col; j++){
          if (data[i][j] < elevation){
            aggDepth +=  elevation - data[i][j];
          }
        }
      }
      return aggDepth * 72 * 72;
    }catch (FileNotFoundException e){
	    System.out.println("File is not found");
	    System.exit(1);
    }
    return 0;
  }

  private static void stomp(int r, int c, int depth, int[][] data){
    int max = 0;
    for (int i=r; i<r+3; i++){
	    for (int j=c; j<c+3; j++){
        int current = data[i][j];
        if (max < current){
          max = current;
        }
	    }
    }
    int newDepth = max - depth;
    for (int i=r; i<r+3; i++){
	    for (int j=c; j<c+3; j++){
        if (data[i][j] > newDepth){
          data[i][j] = newDepth;
        }
	    }
    }
  }
}
