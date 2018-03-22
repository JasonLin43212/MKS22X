import java.util.*;

public class Merge{

    public static void main(String[]args){
	int[] data = {2,3,4,5,1,2,3,1,2,3,1,2,3,1,4,3,1,2,3,1,3,1,2,3,1};
	int[] temp = new int[data.length];
	//Merge.merge(data,ary,0,1,2);
	Merge.mergesort(data);
	System.out.println(Arrays.toString(data));
	//System.out.println(Arrays.toString(temp));
    }

    public static void merge(int[] data, int[] temp, int start, int mid, int end){
	int inc1 = start;
	int inc2 = mid + 1;
	int dataIndex = start;
	while (inc1 <= mid || inc2 <= end){
	    if (inc1 > mid) {
		data[dataIndex] = temp[inc2];
		inc2++;
	    }
	    else if (inc2 > end) {
		data[dataIndex] = temp[inc1];
		inc1++;
	    }
	    else if (temp[inc1] <= temp[inc2]){
		data[dataIndex] = temp[inc1];
		inc1++;
	    }
	    else {
		data[dataIndex] = temp[inc2];
		inc2++;
	    }
	    dataIndex++;
	}
    }

    public static void mergesort(int[] data){
	int[] temp = new int[data.length];
	msort(data,temp,0,data.length-1);
    }

    private static void msort(int[]data, int[]temp, int lo, int hi){
	if (lo >= hi){
	    return;
	}
	for (int i=lo; i<hi; i++){
	    temp[i] = data[i];
	}
	int mid = (lo/2) + (hi/2);
	msort(temp,data,lo,mid);
	msort(temp,data,mid+1,hi);
	merge(data,temp,lo,mid,hi);
    }
}
