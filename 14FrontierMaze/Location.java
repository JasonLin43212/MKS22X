public class Location{
  private int x,y;
  private Location previous;

  public Location(int _x, int _y, Location prev){
    x = _x;
    y = _y;
    previous = prev;
  }

  public getX(){return x;}
  public getY(){return y;}
}
