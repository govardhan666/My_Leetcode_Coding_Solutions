class Solution {
    public void sortColors(int[] nums) {
        //swap 0
        int i=0,j=0;
        for(;j<nums.length;j++){
            if(nums[j]==0){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
            }
        }
        j=i;
        for(;j<nums.length;j++){
            if(nums[j]==1){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
            }
        }
    }
}