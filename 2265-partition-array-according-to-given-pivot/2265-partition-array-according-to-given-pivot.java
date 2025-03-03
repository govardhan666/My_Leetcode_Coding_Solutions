class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int l=0;
        int k=0;
        int r=0;
        int[] left= new int[n];
        int[] right = new int[n];
        for(int i=0;i<n;i++){
            if(nums[i]<pivot){
               left[l++]=nums[i];
            }else if(nums[i]> pivot){
                right[r++] = nums[i];
            }else{
                k++;
            }
        }

        int[] result = new int[n];
        int index =0;
        for(int i=0;i<l;i++){
            result[index++] = left[i];
        }
        for(int i=0;i<k;i++){
            result[index++] = pivot;

        }for(int i=0;i<r;i++){
            result[index++] = right[i];
        }
        return result;
    }
}