class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
          Map<Integer, Long>map = new HashMap<>(); 
         map.put(0, 1L); // base case for prefix
         long count = 0;
         int prefix = 0;

         for (int num : nums) {
            if (num % modulo == k) {
                prefix++;
            }

            int currentMod = prefix % modulo;
            int targetMod = (currentMod - k + modulo) % modulo;

            count += map.getOrDefault(targetMod, 0L);
        map.put(currentMod, map.getOrDefault(currentMod, 0L) + 1);
        }   
        return count;  
    }
}