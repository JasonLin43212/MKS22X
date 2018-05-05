import java.util.Arrays;

public class MazeSolver{

  public static void main(String[]args){
    MazeSolver m = new MazeSolver("test1.txt");
    System.out.println(m);
    m.solve();
    System.out.println(m);
  }

  private Maze maze;
  private Frontier frontier;
  private boolean hasAttempted;

  public MazeSolver(String fileName){
    maze = new Maze(fileName);
  }

  //Default to BFS
  public boolean solve(){ return solve(0); }

  //mode: required to allow for alternate solve modes.
  //0: BFS
  //1: DFS
  public boolean solve(int mode){
    //initialize your frontier
    if (mode == 1){
      frontier = new FrontierStack();
    }
    else if (mode == 0) {
      frontier = new FrontierQueue();
    }
    frontier.add(maze.getStart());
    Location end = maze.getEnd();
    //while there is stuff in the frontier:
    //  get the next location
    //  process the location to find the locations (use the maze to do this)
    //  check if any locations are the end, if you found the end just return true
    //  add all the locations to the frontier
    //when there are no more values in the frontier return false
    while (frontier.hasNext()){
      Location[] newLocations = maze.getNeighbors(frontier.next());
      for (int i=0; i<newLocations.length; i++){
        Location cur = newLocations[i];
        if (cur != null){
          maze.set(cur.getX(),cur.getY(),'.');
          if (cur.equals(end)){
            maze.end = new Location(maze.end.getX(),maze.end.getY(),cur.getPrev());
            maze.set(maze.getEnd().getX(),maze.getEnd().getY(),'E');
            return true;
          }
          frontier.add(cur);
        }
      }
    }
    return false;
  }

  public String toString(){
    Location cur = maze.getEnd().getPrev();
    while (cur!=null){
      maze.set(cur.getX(),cur.getY(),'@');
      cur = cur.getPrev();
    }
    maze.set(maze.start.getX(),maze.start.getY(),'S');
    return maze.colorize(maze.toString());
  }
}
