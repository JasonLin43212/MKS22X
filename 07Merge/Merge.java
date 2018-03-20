public class Merge{

    public static void main(String[]args){
	
    }

    public static void merge(int[] data, int[] temp, int start, int mid, int end){
	int inc1 = start;
        int inc2 = mid + 1;
	int dataIndex = start;
	while (inc1 <= mid || inc2 <= end){
	    if (inc1 > mid) {
		data[dataIndex] = temp[inc2];
	    }
	    if (inc2 > end) {
		data[dataIndex] = temp[inc1];
	    }
	    if (temp[inc1]
	}
    }

}
