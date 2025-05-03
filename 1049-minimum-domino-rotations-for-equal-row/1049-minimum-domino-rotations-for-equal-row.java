class Solution {
    public int minDominoRotations(int[] tops, int[] bottom) {
        int res = Math.min(helper(tops[0],tops,bottom),helper(bottom[0],tops,bottom));
        return res==Integer.MAX_VALUE?-1:res;
    }
    int helper(int x,int[] tops,int[] bottom){
        int ans = 0;
        int ans2=0;
        for(int i = 0;i<tops.length;i++){
            if(tops[i]!=x && bottom[i]!=x){
                return Integer.MAX_VALUE;
            }
            else if(tops[i]!=x && bottom[i]==x){
                ans++;
            }
            else if(bottom[i]!=x && tops[i]==x){
                ans2++;
            }
        }
        return Math.min(ans,ans2);
    }
}