import java.util.*;

public class MazeSolver{

  public static void main(String[]args){
    MazeSolver m = new MazeSolver("test1.txt");
    System.out.println(m);
    m.setAnimate(true);
    m.solve();
    System.out.println(m);
  }

  private Maze maze;
  private Frontier frontier;
  private boolean hasAttempted;
  private boolean willAnimate;

  public MazeSolver(String fileName){
    maze = new Maze(fileName);
    willAnimate = false;
  }

  private void wait(int millis){
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }

  public void setAnimate(boolean val){
    willAnimate = val;
  }
  //Default to BFS
  public boolean solve(){ return solve(0); }

  //mode: required to allow for alternate solve modes.
  //0: BFS
  //1: DFS
  //2: Best-First Search
  public boolean solve(int mode){
    //initialize your frontier
    if (mode == 1){
      frontier = new FrontierStack();
    }
    else if (mode == 0) {
      frontier = new FrontierQueue();
    }
    else if (mode == 2){
      frontier = new FrontierPriorityQueue();
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
      if (willAnimate){
        System.out.println("\033[2J\033[1;1H");
        System.out.println(this);
        wait(30);
      }
      Location next = frontier.next();
      maze.set(next.getX(),next.getY(),'.');
      Location[] newLocations = maze.getNeighbors(next);
      for (int i=0; i<newLocations.length; i++){
        Location cur = newLocations[i];
        if (cur != null){
          if (cur.equals(end)){
            maze.end = new Location(maze.end.getX(),maze.end.getY(),cur.getPrev(),0);
            maze.set(maze.getEnd().getX(),maze.getEnd().getY(),'E');
            return true;
          }
          frontier.add(cur);
          maze.set(cur.getX(),cur.getY(),'?');
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
      if (willAnimate){
        System.out.println("\033[2J\033[1;1H");
        System.out.println(maze.colorize(maze.toString()));
        wait(30);
      }
    }
    maze.set(maze.start.getX(),maze.start.getY(),'S');
    return maze.colorize(maze.toString());
  }
}
