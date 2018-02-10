import java.util.*;

public class QueenBoard{

  public static void main(String[]args){
    QueenBoard q = new QueenBoard(4);
    System.out.println(q.solve());
    System.out.println(q);

  }

  private int[][] board;
  private int size;

  public QueenBoard (int size) {
    board = new int[size][size];
    this.size = size;
  }

  public boolean addQueen(int r, int c){
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

  public boolean removeQueen(int r, int c){
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
        /*
        else {
          output += "_ ";
        }
        */
        else {
          output += board[r][c] + " ";
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
      if (column == 0) {
        return false;
      }
      for (int r=0; r<size; r++){
        if (board[r][column-1] == -1){
          removeQueen(r,column-1);
          return solveHelper(r+1,column-1);
        }
      }
    }
    if (column == size -1){
      if (addQueen(row,column)){
        return true;
      }
      return solveHelper(row+1,column);
    }
    if (addQueen(row,column)){
      return solveHelper(0,column+1);
    }
    return solveHelper(row+1,column);
  }

}
