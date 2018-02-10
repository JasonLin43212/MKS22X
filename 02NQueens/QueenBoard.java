import java.util.*;

public class QueenBoard{

  public static void main(String[]args){
    QueenBoard q = new QueenBoard(7);
    System.out.println(q.countSolutions());
    System.out.println(q);
  }

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
    for (int i=c+1; i<size; i++){
      board[r][i]++;
    }
    for (int i=1; r+i<size && c+i<size; i++){
      board[r+i][c+i]++;
    }
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
     for (int i=c+1; i<size; i++){
      board[r][i]--;
    }
    for (int i=1; r+i<size && c+i<size; i++){
      board[r+i][c+i]--;
    }
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
    return solveHelper(0,0);
  }

  private boolean solveHelper(int row, int column){
    if (row == size){
      //Once you backtracked all the way to the beginning and still
      //haven't found any solutions, then there are no solutions
      if (column == 0) {
        return false;
      }
      //This removes the previous queen and adds in a new one right after it
      for (int r=0; r<size; r++){
        if (board[r][column-1] == -1){
          removeQueen(r,column-1);
          return solveHelper(r+1,column-1);
        }
      }
    }

    //This case is for a solved board
    if (column == size){
      return true;
    }

    if (addQueen(row,column)){
      return solveHelper(0,column+1);
    }
    return solveHelper(row+1,column);
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
