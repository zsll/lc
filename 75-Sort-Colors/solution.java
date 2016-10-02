public class Solution {
    public void sortColors(int[] a) {
        if(a != null && a.length > 1) {
            int zeroE = 0, twoS = a.length - 1;
            for(int i = 0; i <= twoS; i++) {
                switch(a[i]) {
                    case 0:
                        if(i > zeroE) {
                            swap(a, i, zeroE); 
                        }
                        zeroE++;
                        break;
                    case 2:
                        if(i < twoS) {
                            swap(a, i, twoS); 
                        }
                        twoS--;
                        i--;
                        break;
                    default:
                        break;
                }
            }
        }
    }
    
    public void swap (int [] a, int i, int j) {
    	int temp = a[i];
    	a[i] = a[j];
    	a[j] = temp;
    }
}