class Solution {
    public int findComplement(int num) {
        String s = Integer.toBinaryString(num);
        char[] ch = s.toCharArray();
        int res = 0 ;
        int n = ch.length;
        for(int i=0;i<n;i++){
            if(ch[i] == '0'){
                res += Math.pow(2,n-i-1);
            }
        }
        return res;
    }
}