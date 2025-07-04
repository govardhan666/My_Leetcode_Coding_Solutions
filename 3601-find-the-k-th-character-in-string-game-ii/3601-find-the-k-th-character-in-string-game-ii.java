class Solution {
    public char kthCharacter(long k, int[] operations) {
        int ch = 0;
        k--;
        for(int i=0;k!=0;i++,k>>=1){
            ch+=(int)((k&1) & operations[i]);
        }
        return (char) ('a'+ch%26);
    }
}