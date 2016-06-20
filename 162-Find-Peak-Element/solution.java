public class Solution {

    private int[] arr;
	public int findPeakElement(int[] num) {
		arr = num;
		return findPeak(0, num.length - 1);
    }
	private int findPeak(int from, int to) {
        int mid = from + to >> 1; //NoteNote: moves right equals divided by 2
		if (isPeak(mid) == 0) return mid;
        if (isPeak(mid) == -1) return findPeak (from, mid - 1);
        else return findPeak(mid + 1, to);
	}
	
	//return 0 mean peak, 1 means up or even, -1 means down or even
    private int isPeak(int i) {
    	if(!biggerThanNext(i)) {
    		return 1;
    	} else if (!biggerThanPre(i)) {
    		return -1;
    	} else {
    		return 0;
    	}
    	
    }
  
    //last or bigger than next
    private boolean biggerThanNext(int i) {
    	return i == arr.length - 1 || arr[i] > arr[i + 1];	//NoteNote: this problem no adjacent elements are equal, edge are considered as minimum value
    }
    //first or bigger than previous
    private boolean biggerThanPre(int i) {
        return i == 0 || arr[i] > arr[i - 1];
    }
}