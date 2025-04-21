class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min=0,max=0;
        int curr=0;
        for (int i=0;i<differences.length;i++){
            curr+=differences[i];
            min=Math.min(min,curr);
            max=Math.max(curr,max);
        }
        long count=(upper-max)-(lower-min)+1;
        return (count>=0)?(int)count:0;
    }
}