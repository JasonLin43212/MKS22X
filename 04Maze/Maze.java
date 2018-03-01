import java.util.*;
import java.io.*;

public class Maze{


  private char[][]maze;
  private boolean animate;//false by default

  /*Constructor loads a maze text file, and sets animate to false by default.

    1. The file contains a rectangular ascii maze, made with the following 4 characters:
    '#' - Walls - locations that cannot be moved onto
    ' ' - Empty Space - locations that can be moved onto
    'E' - the location of the goal (exactly 1 per file)

    'S' - the location of the start(exactly 1 per file)

    2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!


     
    3. When the file is not found OR the file is invalid (not exactly 1 E and 1 S) then: 

    throw a FileNotFoundException or IllegalStateException

  */

  public Maze(String filename) throws FileNotFoundException{
    Scanner inf = new Scanner(new File(filename));

    String data = "";
    int width = 0;
    int height = 0;
    int numE = 0;
    int numS = 0;
	
    while (inf.hasNextLine()){
	    String line = inf.nextLine();
	    width = line.length();
	    height++;
	    data += line;
    }

    for (int i=0; i<data.length(); i++){
	    String character = data.substring(i,i+1);
	    if (character.equals("E")){
        numE++;
	    }
	    if (character.equals("S")){
        numS++;
	    }
    }

    if (numE != 1 || numS != 1){
	    throw new IllegalStateException();
    }

    maze = new char[height][width];

    for (int i=0; i<height; i++){
	    for (int j=0; j<width; j++){
        maze[i][j]  = data.charAt(i*width+j); 
	    }
    }
  }

  public String toString(){
    String output = "";
    for (int i=0; i<maze.length; i++){
	    for (int j=0; j<maze[0].length; j++){
        output += maze[i][j];
	    }
	    output += "\n";
    }
    return output;
  }

  private void wait(int millis){
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }


  public void setAnimate(boolean b){

    animate = b;

  }


  public void clearTerminal(){

    //erase terminal, go to top left of screen.

    System.out.println("\033[2J\033[1;1H");

  }



  /*Wrapper Solve Function returns the helper function

    Note the helper function has the same name, but different parameters.
    Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.

  */
  public int solve(){

    int startRow = 0;
    int startCol = 0;
    //find the location of the S. 
    for (int i=0; i<maze.length; i++){
	    for (int j=0; j<maze[0].length; j++){
        if (maze[i][j] == 'S'){
          startRow = i;
          startCol = j;
        }
	    }
    }

    //erase the S
    maze[startRow][startCol] = ' ';
    //and start solving at the location of the s.

    System.out.println(startRow+" "+startCol);
    return solve(startRow,startCol,0);

  }

  /*
    Recursive Solve function:

    A solved maze has a path marked with '@' from S to E.

    Returns the number of @ symbols from S to E when the maze is solved,
    Returns -1 when the maze has no solution.


    Postcondition:

    The S is replaced with '@' but the 'E' is not.

    All visited spots that were not part of the solution are changed to '.'

    Note: This is not required based on the algorithm, it is just nice visually to see.
    All visited spots that are part of the solution are changed to '@'
  */
  private int solve(int row, int col, int numMoves){ //you can add more parameters since this is private

    if (maze[row][col] == 'E'){
      return numMoves;
    }
    maze[row][col] = '@';
    //automatic animation! You are welcome.
    if(animate){

      clearTerminal();
      System.out.println(this);

      wait(30);
    }

    //COMPLETE SOLVE
    

    // Right
    if (isValidMove(row,col+1)){
      int newNumMoves = solve(row,col+1,numMoves+1);
      if (newNumMoves != -1){
        return newNumMoves;
      }
    }
    // Down
    if (isValidMove(row+1,col)){
      int newNumMoves = solve(row+1,col,numMoves+1);
      if (newNumMoves != -1){
        return newNumMoves;
      }
    }
    // Left
    if (isValidMove(row,col-1)){
      int newNumMoves = solve(row,col-1,numMoves+1);
      if (newNumMoves != -1){
        return newNumMoves;
      }
    }
    // Up
    if (isValidMove(row-1,col)){
      int newNumMoves = solve(row-1,col,numMoves+1);
      if (newNumMoves != -1){
        return newNumMoves;
      }
    }
    maze[row][col] = '.';

    return -1; //so it compiles
  }

  private boolean isValidMove(int row, int col){
    char current = maze[row][col];
    return current != '#' && current != '.' && current != '@';
  }
}
