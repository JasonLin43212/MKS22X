import java.io.*;

public class Driver{

    public static void main(String[]args){
        Maze f;
	try {
	    f = new Maze("data1.dat");//true animates the maze.
	    
	    //f.setAnimate(true);
	    //f.solve();

	    System.out.println(f);
	}catch (FileNotFoundException e){
	    System.out.println("The file can not be found");
	}catch (IllegalStateException e){
	    System.out.println("The maze is invalid. Please have exactly one 'S' and one 'E'");
	}
    }
}
