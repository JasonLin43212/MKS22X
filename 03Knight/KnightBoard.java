import java.util.*;

public class KnightBoard {

  /*
  public static void main(String[]args){
    KnightBoard k = new KnightBoard(9,9);
      
    k.solve(0,0);
    //System.out.println(k.countSolutions(0,0));
    //k.removeKnight(2,3);
    //k.solveFast(0,0);
    System.out.println(k.isSolutionGood(0,0));
    System.out.println(k);
    //System.out.println(k.toStringMoves());
  }
  */

  public static void main(String[] args){
    KnightBoard a = new KnightBoard(3,3);

    System.out.println(a);
    /* Prints
      _ _ _
      _ _ _
      _ _ _
    */

    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        if (a.solve(i,j)){
          System.out.println("There is an error with your solve method");
        }
      }
    } //prints nothing

    System.out.println(a.countSolutions(0,0)); //prints 0



    KnightBoard b = new KnightBoard(5,5);
    System.out.println(b.solve(0,0)); //prints true
    System.out.println(b); //prints a valid solution

    try{
      b.solve(0,0);
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    try{
      b.countSolutions(0,0);
    }catch(IllegalStateException e){
      System.out.println("Error: The board contains non-zero values");
    } //prints "Error: The board contains non-zero values"

    try{
      KnightBoard b1 = new KnightBoard(-1,0);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"

    try{
      KnightBoard b1 = new KnightBoard(1,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"

    try{
      KnightBoard b1 = new KnightBoard(-1,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters in the constructor");
    } //prints "Error: There cannot be negative parameters in the constructor"

    try{
      KnightBoard b1 = new KnightBoard(5,5);
      b1.solve(0,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"

    try{
      KnightBoard b1 = new KnightBoard(5,5);
      b1.solve(-1,0);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"

    try{
      KnightBoard b1 = new KnightBoard(5,5);
      b1.solve(-1,-1);
    }catch(IllegalArgumentException e){
      System.out.println("Error: There cannot be negative parameters");
    } //prints "Error: There cannot be negative parameters"



    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        KnightBoard abc = new KnightBoard(5,5);
        System.out.println(abc.solve(i,j)); //prints alternating lines of true/false starting with true
      }
    }
    KnightBoard c = new KnightBoard(5,5);

    int totalSol = 0;
    for (int i = 0; i < 5; i++){
      for (int j = 0; j < 5; j++){
        totalSol += c.countSolutions(i,j);
      }
    }

    System.out.println(totalSol); //prints 1728

    KnightBoard d = new KnightBoard(5,5);
    System.out.println(d.countSolutions(0,0)); //prints 304

  }
  
  private int[][] board;
  private int[][] validMoves;
  private int row;
  private int col;
  private int[][] knightMoves = {{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};
    
  public KnightBoard(int startingRows,int startingCols){
    if (startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
    }
    board = new int[startingRows][startingCols];
    validMoves = new int[startingRows][startingCols];
    row = startingRows;
    col = startingCols;
    //New stuff
    for (int r=0; r<row; r++){
      for (int c=0; c<col; c++){
        for (int i=0; i<8; i++){
          int newRow = r + knightMoves[i][0];
          int newCol = c + knightMoves[i][1];
          if (!isOutOfRange(newRow,newCol)){
            validMoves[r][c]++;
          }
        }
      }
    }
  }

  public String toString(){
    String output = "";
    for (int i=0; i<row; i++){
	    for (int j=0; j<col; j++){
        if (board[i][j]==0){
          output += "____ ";
        }
        else if (board[i][j] < 10){
          output += "   " + board[i][j] + " ";
        }
        else if (board[i][j] < 100){
          output += "  " + board[i][j] + " ";
        }
        else if (board[i][j] < 1000){
          output += " " + board[i][j] + " ";
        }
        else {
          output += board[i][j] + " ";
        }
	    }
	    output += "\n";
    }
    return output;
  }

  public String toStringMoves(){
    String output = "";
    for (int i=0; i<row; i++){
      for (int j=0; j<col; j++){
        if (validMoves[i][j] < 10){
          output += " " + validMoves[i][j] + " ";
        }
        else {
          output += validMoves[i][j] + " ";
        }
      }
      output += "\n";
    }
    return output;
  }

  public boolean solve(int startingRow, int startingCol){
    if (isOutOfRange(startingRow,startingCol)) {
      throw new IllegalArgumentException();
    }
    for (int r = 0; r<row; r++){
      for (int c = 0; c<col; c++){
        if (board[r][c] != 0){
          throw new IllegalStateException();
        }
      }
    }
    return solveFastHelper(startingRow, startingCol, 1);
  }
  
  private boolean solveHelper(int row, int col, int level){
    board[row][col] = level;
    if (level == this.row * this.col){
      return true;
    }
    /*
      System.out.println(Text.CLEAR_SCREEN);
      System.out.println(Text.go(1,1));
      System.out.println(this);
      Text.wait(2000); //adjust this delay
    */
    for (int i=0; i<8; i++){
      int newRow = row + knightMoves[i][0];
      int newCol = col + knightMoves[i][1];
      if (isValid(newRow,newCol)){
        if (solveHelper(newRow, newCol, level+1)){
          return true;
        }
        board[newRow][newCol] = 0;
      }
    }
    board[row][col] = 0;
    return false;
  }

  public int countSolutions(int startingRow, int startingCol){
    if (isOutOfRange(startingRow,startingCol)) {
      throw new IllegalArgumentException();
    }
    for (int r = 0; r<row; r++){
      for (int c = 0; c<col; c++){
        if (board[r][c] != 0){
          throw new IllegalStateException();
        }
      }
    }
    return countSolutionsHelper(startingRow,startingCol,1);
  }

  private int countSolutionsHelper(int row, int col, int level){
    int numSolution = 0;
    board[row][col] = level;
    if (level == this.row * this.col){
      return 1;
    }
    for (int i=0; i<8; i++){
      int newRow = row + knightMoves[i][0];
      int newCol = col + knightMoves[i][1];
      if (isValid(newRow,newCol)){
        numSolution += countSolutionsHelper(newRow, newCol, level+1);
        board[newRow][newCol] = 0;
      }
    }
    board[row][col] = 0;
    return numSolution;
  }

  private boolean isOutOfRange(int row, int col){
    return row < 0 || row >= this.row || col < 0 || col >= this.col;
  }

  private boolean isValid(int row, int col){
    return !isOutOfRange(row,col) && board[row][col] == 0;
  }

  public boolean solveFast (int startingRow, int startingCol){
    if (isOutOfRange(startingRow,startingCol)) {
      throw new IllegalArgumentException();
    }
    for (int r = 0; r<row; r++){
      for (int c = 0; c<col; c++){
        if (board[r][c] != 0){
          throw new IllegalStateException();
        }
      }
    }
    return solveFastHelper(startingRow, startingCol, 1);
  }

  private boolean solveFastHelper(int row, int col, int level){
    board[row][col] = level;
    addKnight(row,col);
    if (level == this.row * this.col){
	    return true;
    }
    int[] possibleMoves = {9,9,9,9,9,9,9,9};
    /*
    System.out.println(Text.CLEAR_SCREEN);
      System.out.println(Text.go(1,1));
      System.out.println(this);
      System.out.println(this.toStringMoves());
      System.out.println(Arrays.toString(possibleMoves));
      Text.wait(3000); //adjust this delay
    */
    for (int i = 0; i<8; i++){
      for (int j = 0; j<8; j++){
        int newRow = row + knightMoves[j][0];
        int newCol = col + knightMoves[j][1];
        if (isValid(newRow,newCol)){
          possibleMoves[j] = validMoves[newRow][newCol];
        }
        if (i == possibleMoves[j] && solveFastHelper(newRow, newCol, level+1)){
          return true;
        }
      }
    }
    board[row][col] = 0;
    removeKnight(row,col);
    return false;
  }
    
  private void addKnight(int row, int col){
    validMoves[row][col] += 9;
    for (int i=0; i<8; i++){
	    int newRow = row + knightMoves[i][0];
	    int newCol = col + knightMoves[i][1];
	    if (isValid(newRow,newCol)){
        validMoves[newRow][newCol]--;
	    }
    }
  }

  private void removeKnight(int row, int col){
    validMoves[row][col] -= 9;
    for (int i=0; i<8; i++){
	    int newRow = row + knightMoves[i][0];
	    int newCol = col + knightMoves[i][1];
	    if (isValid(newRow,newCol)){
        validMoves[newRow][newCol]++;
	    }
    }
  }

  public boolean isSolutionGood(int row, int col){
    int i = 2;
    int max = this.row*this.col;
    while (i<=max) {
      boolean badSolution = true;
      for (int j = 0; j<8; j++){
        int newRow =  row + knightMoves[j][0];
        int newCol = col + knightMoves[j][1];
        if (!isOutOfRange(newRow,newCol) && board[newRow][newCol] == i){
          row = newRow;
          col = newCol;
          badSolution = false;
        }
      }
      if (badSolution){
        return false;
      }
      i++;
    }
    return true;
  }
}
