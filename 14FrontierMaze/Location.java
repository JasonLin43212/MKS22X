public class Location implements Comparable<Location>{
  private int x,y;
  private Location previous;
  private int distance;

  public Location(int _x, int _y, Location prev, int distance){
    x = _x;
    y = _y;
    previous = prev;
    this.distance = distance;
  }

  public int getX(){return x;}
  public int getY(){return y;}
  public int getDistance(){return distance;}
  public Location getPrev(){return previous;}

  public boolean equals(Location other){
    return x == other.getX() && y == other.getY();
  }

  public String toString(){
    return "(" + x + "," + y + "," + distance + ")";
  }

  public int compareTo(Location o){
    return this.distance-o.getDistance();
  }
}
