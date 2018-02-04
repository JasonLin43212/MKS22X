public class Recursion{

  public static void main(String[]args){
    Recursion r = new Recursion();
    System.out.println(r.fact(6));

  }

  public int fact(int n) {
    if (n<0){
      throw new IllegalArgumentException();
    }
    if (n == 0) {
      return 1;
    }
    return n * fact(n-1);
  }
}
