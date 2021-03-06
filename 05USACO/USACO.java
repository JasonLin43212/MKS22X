import java.util.*;
import java.io.*;

public class USACO {
    
  public static void main(String[]args){
    // System.out.println(USACO.bronze("bronze4.dat"));
    System.out.println(USACO.silver("silver5.dat"));
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

  public static int silver(String filename){
    int[][] current, past;
    char[][] map;
    int row,col,numMoves,startRow,startCol,endRow,endCol;
    try {
	    Scanner in = new Scanner (new File (filename));
	    
	    row = Integer.parseInt(in.next());
	    col = Integer.parseInt(in.next());
	    numMoves = Integer.parseInt(in.next());

	    map = new char[row][col];
	    current = new int[row][col];
	    past = new int[row][col];

	    for (int i=0; i<row; i++){
        String line = in.next();
        for (int j=0; j<col; j++){
          map[i][j] = line.charAt(j);
        }
	    }

      startRow = Integer.parseInt(in.next())-1;
      startCol = Integer.parseInt(in.next())-1;
      endRow = Integer.parseInt(in.next())-1;
      endCol = Integer.parseInt(in.next())-1;

      past[startRow][startCol] = 1;

      for (int i=0; i<numMoves; i++){
        for (int r=0; r<row; r++){
          for (int c=0; c<col; c++){
            if (map[r][c] != '*'){
              int sumNeighbors = 0;
              if (isOnBoard(r+1,c,row,col)){
                sumNeighbors += past[r+1][c];
              }
              if (isOnBoard(r-1,c,row,col)){
                sumNeighbors += past[r-1][c];
              }
              if (isOnBoard(r,c+1,row,col)){
                sumNeighbors += past[r][c+1];
              }
              if (isOnBoard(r,c-1,row,col)){
                sumNeighbors += past[r][c-1];
              }
              current[r][c] = sumNeighbors;
            }
          }
        }
        past = current;
        current = new int[row][col];
      }
      
	    return past[endRow][endCol];
    } catch (FileNotFoundException e){
	    System.out.println("File Not Found");
	    System.exit(1);
    }
    return 0;
  }

  public static boolean isOnBoard (int currentR, int currentC, int row, int col){
    return currentR >= 0 && currentC >= 0 && currentR < row && currentC < col;
  }
}
