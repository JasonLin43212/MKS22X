import java.util.*;

public class QueenBoard{


  public static void main(String[]args){
    QueenBoard q = new QueenBoard(26);
    //System.out.println(q.countSolutions());
    System.out.println(q.solve());
    System.out.println(q);
  }
  /*
  public static void main(String[] args){
    QueenBoard b = new QueenBoard(4);

    System.out.println(b.solve()); //prints true
    System.out.println(b); //prints a valid solution

    try{
      b.solve();
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    try{
      b.countSolutions();
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    for (int i = 0; i < 12; i++){
      QueenBoard a = new QueenBoard(i);
      System.out.println("# of Solutions for " + i + ": " + a.countSolutions());
      /*          Expected Values
       i --> # of Solutions   i --> # of Solutions
      0 --> 1                      6 --> 4
      1 --> 1                      7 --> 40
      2 --> 0                      8 --> 92
      3 --> 0                      9 --> 352
      4 --> 2                    10 --> 724
      5 --> 10                  11 --> 2680
      */
  /*
      System.out.println(a); //prints out an empty i by i grid of underscores
    }
  }

*/
  private int[][] board;
  private int size;

  public QueenBoard (int size) {
    if (size < 0) {
      throw new IllegalArgumentException();
    }
    board = new int[size][size];
    this.size = size;
  }

  private boolean addQueen(int r, int c){
    if (board[r][c] > 0){
      return false;
    }
    board[r][c] = -1;
    //Straight to the right
    for (int i=c+1; i<size; i++){
      board[r][i]++;
    }
    //Diagonal down
    for (int i=1; r+i<size && c+i<size; i++){
      board[r+i][c+i]++;
    }
    //Diagonal up
    for (int i=1; r-i>=0 && c+i<size; i++){
      board[r-i][c+i]++;
    }
    return true;
  }

  private boolean removeQueen(int r, int c){
    if (board[r][c] != -1) {
      return false;
    }
    board[r][c]++;
    //Straigh to the right
    for (int i=c+1; i<size; i++){
      board[r][i]--;
    }
    //Diagonal down
    for (int i=1; r+i<size && c+i<size; i++){
      board[r+i][c+i]--;
    }
    //Diagonal Up
    for (int i=1; r-i>=0 && c+i<size; i++){
      board[r-i][c+i]--;
    }
    return true;
  }

  /**
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *Q _ _ _
  *_ _ Q _
  * etc.
  */
  public String toString() {
    String output = "";
    for (int r=0;r<size;r++){
      for (int c=0;c<size;c++){
        if (board[r][c] == -1){
          output += "Q ";
        }
        else {
          output += "_ ";
        }
      }
      output += "\n";
    }
    return output;
  }

  /**
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public boolean solve(){
    for (int r=0; r<size; r++){
      for (int c=0; c<size; c++) {
        if (board[r][c] != 0){
          throw new IllegalStateException();
        }
      }
    }
    return solveHelper(0);
  }

  private boolean solveHelper(int column){
    //Once the column reaches beyond the board, you know it was able to add to the last column
    if (column == size){
      return true;
    }
    for (int row = 0; row<size; row++){
      //Check if you can add a queen there
      if (addQueen(row,column)){
        //Check if the next column can be added to
        //Once it reaches the last column, the true will carry over
        if (solveHelper(column+1)){
          return true;
        }
        //If you are not able to add to the last column from this point
        //remove the queen you just added and try the next one
        removeQueen(row,column);
      }
    }
    return false;
  }

  /**
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value
  */
  public int countSolutions(){
    for (int r=0; r<size; r++){
      for (int c=0; c<size; c++) {
        if (board[r][c] != 0){
          throw new IllegalStateException();
        }
      }
    }
    return countSolutionsHelper(0,0,0);
  }

  private int countSolutionsHelper(int row, int column, int numSolutions){
    if (row == size){
      //Once you backtracked all the way to the beginning
      //you are done checking and should return the numSolutions
      if (column == 0) {
        return numSolutions;
      }
      //This removes the previous queen and adds in a new one right after it
      for (int r=0; r<size; r++){
        if (board[r][column-1] == -1){
          removeQueen(r,column-1);
          return countSolutionsHelper(r+1,column-1,numSolutions);
        }
      }
    }

    //Checks the last column for solutions
    if (column == size-1){
      if (addQueen(row,column)){
        removeQueen(row,column);
        return countSolutionsHelper(row+1,column,numSolutions+1);
      }
      return countSolutionsHelper(row+1,column,numSolutions);
    }

    if (addQueen(row,column)){
      return countSolutionsHelper(0,column+1,numSolutions);
    }
    return countSolutionsHelper(row+1,column,numSolutions);
  }

}
