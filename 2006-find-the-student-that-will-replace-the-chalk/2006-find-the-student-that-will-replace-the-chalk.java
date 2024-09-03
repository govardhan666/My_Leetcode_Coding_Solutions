class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        if(chalk.length == 1){
            return 0;
        }
        int res = 0;
        int i = 0;
        while(k >= 0){
            k -= chalk[i];
            if(k<0){
                res = i;
                break;
            }
            i++;
            if(i>=chalk.length){
                i -= chalk.length;
            }

        }
        return res;
    }
}