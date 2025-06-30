class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int j=0;
        int maxLen=0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            while(nums[i] - nums[j] > 1){
                j++;
            }
            if(nums[i] - nums[j] == 1){
                maxLen = Math.max(maxLen, i-j+1);
            }
        }
        return maxLen;
    }
}