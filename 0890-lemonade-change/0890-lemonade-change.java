class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fives= 0;
        int tens = 0;
        int twentys= 0;
        for(int i=0;i<bills.length;i++){
            if(bills[i] == 5){
                fives++;
            }
            if(bills[i] == 10){
                if(fives != 0){
                    fives--;
                }else{
                    return false;
                }
                tens++;
            }
            if(bills[i] == 20){
                if(fives > 0 && tens> 0){
                    fives--;
                    tens--;
                }else if(fives > 2){
                    fives -= 3;
                }else{
                    return false;
                }
                twentys++;
            }
        }
        return true;
    }
}