class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = 0;
        for(int i=0;i<m;i++){
            sum += rolls[i];
        }
        int actualSum =mean*(n+m);
        int diff = actualSum - sum;
        if(diff < n || diff > n*6){
            return new int[0];
        }
        int base = diff/n;
        int rem = diff%n;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = base + (i<rem ? 1: 0);
        }
        return res;
        
    }
}