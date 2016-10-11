public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
    List<Integer> result = new ArrayList<Integer>();
 
    int n1=0, n2=0;
    int c1=0, c2=0;
 
    for(int i: nums){
        if(c1 > 0 && i==n1){
            c1++;
        }else if(c2 > 0 && i==n2){
            c2++;
        }else if(c1==0){
            c1=1;
            n1=i;
        }else if(c2==0){
            c2=1;
            n2=i;
        }else{
            c1--;
            c2--;
        }
    }
 
    c1=c2=0;
 
    for(int i: nums){
        if(i==n1){
            c1++;
        }else if(i==n2){
            c2++;
        }
    }
 
    if(c1>nums.length/3)
        result.add(n1);
    if(c2>nums.length/3)
        result.add(n2);
 
    return result;
    }
}