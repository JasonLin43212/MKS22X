import java.util.*;

public class QueenBoard{

  public static void main(String[]args){
    QueenBoard q = new QueenBoard(8);

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

}
