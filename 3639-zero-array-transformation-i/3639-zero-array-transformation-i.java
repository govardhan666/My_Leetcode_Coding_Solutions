class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1]; // Difference array for efficient range updates
        
        // Process each query using difference array
        for (int[] q : queries) {
            int li = q[0], ri = q[1];
            diff[li]--; 
            diff[ri + 1]++;
        }

        int currentDecrement = 0; // Tracks how many times an index is decremented

        // Apply the decrements and check if nums can become zero
        for (int i = 0; i < n; i++) {
            currentDecrement += diff[i]; // Apply prefix sum
            if (nums[i] + currentDecrement > 0) {
                return false; // If nums[i] can't be reduced to 0, return false
            }
        }
        return true; // If all elements are 0, return true
    }
}