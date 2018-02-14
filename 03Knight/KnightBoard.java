public class KnightBoard {

  public static void main(String[]args){
    KnightBoard k = new KnightBoard(4,6);
    //k.solve(3,2);
    System.out.println(k.countSolutions(0,0));
    System.out.println(k);
  }

  private int[][] board;
  private int row;
  private int col;
  private int[][] knightMoves = {{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};
    
  public KnightBoard(int startingRows,int startingCols){
    if (startingRows < 0 || startingCols < 0){
	    throw new IllegalArgumentException();
    }
    board = new int[startingRows][startingCols];
    row = startingRows;
    col = startingCols;
  }

  public String toString(){
    String output = "";
    for (int i=0; i<row; i++){
	    for (int j=0; j<col; j++){
        if (board[i][j]==0){
          output += "__ ";
        }
        else if (board[i][j] < 10){
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
    return solveHelper(startingRow, startingCol, 1);
  }
  
  private boolean solveHelper(int row, int col, int level){
    board[row][col] = level;
    if (level == this.row * this.col){
      return true;
    }
    /*Printing out the board
    System.out.println(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1));
    System.out.println(this);
    Text.wait(200); //adjust this delay
    */
    for (int i=0; i<8; i++){
      int newRow = row + knightMoves[i][0];
      int newCol = col + knightMoves[i][1];
      if (!isOutOfRange(newRow,newCol) && board[newRow][newCol] == 0 ){
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
      if (!isOutOfRange(newRow,newCol) && board[newRow][newCol] == 0 ){
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

}
