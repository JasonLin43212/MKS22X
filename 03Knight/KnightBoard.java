public class KnightBoard {

    public static void main(String[]args){
	KnightBoard k = new KnightBoard(4,6);
	System.out.println(k);
    }

    private int[][] board;
    private int row;
    private int col;
    private int[][] knightMoves = {{1,2},{2,1},{1,-2},{2,-1},{-1,2},{-2,1},{-1,-2},{-2,-1}};
    
    public KnightBoard(int startingRows,int startingCols){
	board = new int[startingRows][startingCols];
	row = startingRows;
	col = startingCols;
    }

    public String toString(){
	String output = "";
	for (int i=0; i<row; i++){
	    for (int j=0; j<col; j++){
		if (board[i][j]==0){
		    output += "_ ";
		}
		else if (row * col > 9) {
		    if (board[i][j] < 10){
			output += board[i][j];
		    }
		    else {
			output += " " + board[i][j];
		    }
		}
	    }
	    output += "\n";
	}
	return output;
    }

    
}
