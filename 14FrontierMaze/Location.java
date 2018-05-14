public class Location implements Comparable<Location>{
  private int x,y;
  private Location previous;
  private int distance;
  private int soFar;

  public Location(int _x, int _y, Location prev, int distance, int soFar){
    x = _x;
    y = _y;
    previous = prev;
    this.distance = distance;
    this.soFar = soFar;
  }

  public int getX(){return x;}
  public int getY(){return y;}
  public int getDistance(){return distance;}
  public int getSoFar(){return soFar;}
  public Location getPrev(){return previous;}

  public boolean equals(Location other){
    return x == other.getX() && y == other.getY();
  }

  public String toString(){
    return getTotalDistance()+"";
  }

  public int getTotalDistance(){
    return distance + soFar;
  }

  public int compareTo(Location o){
    return this.getTotalDistance()-o.getTotalDistance();
  }
}
