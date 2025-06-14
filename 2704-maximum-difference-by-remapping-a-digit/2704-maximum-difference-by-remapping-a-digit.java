class Solution {
    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        char[] arr = s.toCharArray();
        char u = '9';
        char l = '0';
        for(char ch:arr){
            if(ch!='9') {
                u=ch;
                break;
            }
        }
        for(char ch:arr){
            if(ch!='0') {
                l=ch;
                break;
            }
        }
        int max =Integer.valueOf(s.replace(u,'9'));
        int min = Integer.valueOf(s.replace(l,'0'));
        return max-min;

    }
}