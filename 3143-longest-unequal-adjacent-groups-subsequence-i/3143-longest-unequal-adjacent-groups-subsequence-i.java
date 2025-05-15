        class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int start=groups[0];
        List<String> ans=new ArrayList<>();
        ans.add(words[0]);
        for(int i=1;i<words.length;i++){
            if(groups[i]!=start){
                ans.add(words[i]);
                start=groups[i];
            }
        }
        return ans;
    }
}