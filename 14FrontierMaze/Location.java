public class Location{
  private int x,y;
  private Location previous;

  public Location(int _x, int _y, Location prev){
    x = _x;
    y = _y;
    previous = prev;
  }

  public int getX(){return x;}
  public int getY(){return y;}
  public Location getPrev(){return previous;}

  public boolean equals(Location other){
    return x == other.getX() && y == other.getY();
  }

  public String toString(){
    return "(" + x + "," + y + ")";
  }
}
