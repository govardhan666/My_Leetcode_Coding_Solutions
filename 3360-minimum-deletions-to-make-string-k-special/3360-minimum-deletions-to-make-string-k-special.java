class Solution {
    public int minimumDeletions(String word, int k) {
        
        int[] arr = new int[26];
        int uniqueCharacters = 0;
        for(char ch: word.toCharArray())
        {
            if(arr[(int)(ch-'a')] == 0) uniqueCharacters++;
            arr[(int)(ch-'a')]++;
        }
        
        int[] frequency = new int[uniqueCharacters];
        int idx = 0;
        for (int count : arr) {
            if (count > 0) {
                frequency[idx++] = count;
            }
        }

        Arrays.sort(frequency);
        
        int minDeletions = Integer.MAX_VALUE;
        
        /* Consider every freq as the Minimum Freq ( baseFreq ) and check with it ..... 3 Possible cases
        1. Delete Every Freq which is less than this ( SINCE baseFreq is our minimum)
        2. Allowed Limit = baseFreq + k 
        ... So ... if any Freq is greater than Allowed Limit Reduce it to allowedLimit
        3. Baaki toh within range hai ( No Change in them )
        
        */
        for (int i = 0; i < frequency.length; i++) 
        {
            int baseFreq = frequency[i];
            int deletions = 0;
            int allowedLimit = baseFreq + k;
            
            for (int j = 0; j < frequency.length; j++) 
            {
                if (frequency[j] < baseFreq) {
                    deletions += frequency[j];
                } 
                else if (frequency[j] > baseFreq + k) 
                {
                    deletions += frequency[j] - (baseFreq + k);
                }
            }
            minDeletions = Math.min(minDeletions, deletions);
        }
        return minDeletions;
    }
}