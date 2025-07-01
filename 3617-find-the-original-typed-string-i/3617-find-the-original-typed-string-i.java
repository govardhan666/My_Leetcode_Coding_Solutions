class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int count = n;
        for(int i=1;i<n;i++){
            if(word.charAt(i-1)!=word.charAt(i)){
                count--;
            }
        }
        return count;
    }
}