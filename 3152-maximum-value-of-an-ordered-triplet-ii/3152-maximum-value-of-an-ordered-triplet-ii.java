class Solution {
    public long maximumTripletValue(int[] nums) {
        int n=nums.length;
        long sum=0;
        long pre_max= nums[0];
        long maxdif=Long.MIN_VALUE;
        for(int i=1;i<n-1;i++)
        {
            maxdif=Math.max(maxdif,(long)pre_max-nums[i]);
            sum=Math.max(sum,maxdif*nums[i+1]);
            pre_max=Math.max(pre_max,nums[i]);
        }
        return sum;
    }
}