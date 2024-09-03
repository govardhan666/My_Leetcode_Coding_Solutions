class Solution {
    public int getLucky(String s, int k) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            sb.append(s.charAt(i)-'a'+1);
        }
        while(k>0){
            int sum = 0;
            for(int i=0;i<sb.length();i++){
                sum += Character.getNumericValue(sb.charAt(i));
            }
            sb = new StringBuilder().append(sum);
            k--;
        }
        return Integer.parseInt(sb.toString());
    }
}