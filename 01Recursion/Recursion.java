public class Recursion{

  public static void main(String[]args){
    Recursion r = new Recursion();
    System.out.println(r.fact(6));
    System.out.println(r.fib(7));
    System.out.println(r.sqrt(3));

    System.out.println(r.isPossible(3,5));
    System.out.println(r.isPossible(3,6));
    System.out.println(r.isPossible(3,7));
    System.out.println(r.isPossible(4,5));
    System.out.println(r.isPossible(4,11));
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

  public double sqrt(double n){
    if (n<0) {
      throw new IllegalArgumentException();
    }
    if (n==0){
      return 0;
    }
    return sqrtHelper(n, 1);
  }

  private double sqrtHelper(double n, double guess) {
    if (Math.abs(guess*guess-n)<0.000000001){
      return guess;
    }
    return sqrtHelper(n,(n/guess+guess)/2);
  }

  /*
  public boolean isPossible(int n, int target){
    if (n<0) {
      throw new IllegalArgumentException();
    }
    return isPossibleHelper(n,target,0);
  }

  public boolean isPossibleHelper(int n, int target, int sum){
    if (n == 0) {
      return target == sum;
    }
    return isPossibleHelper(n-1,target,sum+n) || isPossibleHelper(n-1,target,sum);
  }
  */

  public boolean isPossible(int n, int target){
    if (n<0) {
      throw new IllegalArgumentException();
    }
    if (n == 0) {
      return target == 0;
    }
    return isPossible(n-1,target-n) || isPossible(n-1,target);
  }
}
