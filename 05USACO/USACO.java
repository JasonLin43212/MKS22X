import java.util.*;
import java.io.*;

public class USACO {
    
    public static void main(String[]args){
	USACO.bronze("bronze1.dat");
    }


    public static int bronze(String filename){
	int[][] data;
	int row,col,elevation,numInstructions;
	try {
	    File f = new File(filename);
	    Scanner in = new Scanner(f);
	    row = in.next();
	    col = in.next();
	    elevation = in.next();
	    numInstructions = in.next();
	    data = new int[row][col];
	    for (int i=0; i<row; i++){
		for (int j=0; j<c
	    }
	}catch (FileNotFoundException e){
	    System.out.println("File is not found");
	    System.exit(1);
	}
	return 1;

    }
}
