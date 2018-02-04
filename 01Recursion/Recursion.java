public class Recursion{

  public static void main(String[]args){
    Recursion r = new Recursion();
    System.out.println(r.fact(6));
    System.out.println(r.fib(7));
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

  public int fib(int n) {
    if (n < 0) {
      throw new IllegalArgumentException();
    }
    return fibHelper(n,1,0);
  }

  private int fibHelper(int n,int m, int sum){
    if (n<1){
      return sum;
    }
    return fibHelper(n-1,m+sum,m);
  }
}
