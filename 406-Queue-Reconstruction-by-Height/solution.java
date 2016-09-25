public class Solution {
    public int[][] reconstructQueue(int[][] people) {
         List<int[]> list = new ArrayList<int[]>();
        Arrays.sort(people,new Comparator<int[]>(){
            @Override
            public int compare(int[] array1,int[] array2){
                if(array1[0]!=array2[0]){
                    return array2[0]-array1[0];
                }else{
                    return array1[1]-array2[1];
                }
            }
        });
        for(int[] a:people){
            list.add(a[1],a);
        }
        return (int[][])list.toArray(new int[0][0]);
    }
}